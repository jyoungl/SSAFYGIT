package jun27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1388_바닥장식_이주영 {
	static boolean[][] check;
	static char[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt = 0;
	static int N, M;
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		check[x][y] = true;
		int di = arr[x][y] == '-' ? 2:0;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int d=di;d<di+2;d++) {
				int dx = now[0] + dr[d];
				int dy = now[1] + dc[d];
				
				if(dx<0 || dx>=N || dy<0 || dy>=M || check[dx][dy])
					continue;

				if(arr[x][y] == arr[dx][dy]) {
					check[dx][dy] = true;
					que.add(new int[] {dx,dy});
				}			
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		check = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!check[i][j]) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}

}
