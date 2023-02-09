package feb09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//2:05 ~
public class BJ_16918_봄버맨_이주영 {
	public static class Bomb {
		int x;
		int y;

		public Bomb(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R,C,N,idx,time;
	static char[][] arr;
	static ArrayList<Bomb>[] list;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		list = new ArrayList[N];
		
		for(int i=0;i<N;i++)
			list[i] = new ArrayList<>();
		
		idx = 0;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			for(int j=0;j<C;j++) {
				arr[i][j] = ch[j];
				if(arr[i][j] == 'O') {
					list[idx].add(new Bomb(i,j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(N==0 || N==1) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					sb.append(arr[i][j]);
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}
		time=0;
		for(int t=2;t<=N;t++) {
			bomb(t);
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				sb.append(arr[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void bomb(int t) {
		t %= 2;
		switch(t) {
		case 0:
			idx++;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j] == '.') {
						list[idx].add(new Bomb(i,j));
						arr[i][j] = 'O';
						System.out.println(idx);
					}
				}
			}
			break;
		case 1:
			boolean[][] flag = new boolean[R][C];
			for(int i=0;i<list[time].size();i++) {
				Bomb b = list[time].get(i);
				if(arr[b.x][b.y] == '.')
					continue;
				System.out.println(b.x+" "+b.y);
				flag[b.x][b.y] = true;
				for(int d=0;d<4;d++) {
					int dx = b.x + dr[d];
					int dy = b.y + dc[d];
					if(dx<0||dx>=R||dy<0||dy>=C)
						continue;
					
					flag[dx][dy] = true;
				}
			}
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(flag[i][j]) {
						arr[i][j] = '.';
						
					}
				}
			}
			
			time++;
			break;
		}
	}
}
