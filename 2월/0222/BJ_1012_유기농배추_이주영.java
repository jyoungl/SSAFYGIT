package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추_이주영 {
	static int[][] arr;
	static boolean[][] check;
	static int[] dr = {1, -1, 0, 0}; //아래, 위, 오른쪽, 왼쪽
	static int[] dc = {0, 0, 1, -1};
	static int M;
	static int N;
	static int K;
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nowx = x+dr[i];
			int nowy = y+dc[i];
			
			if(nowx>=0 && nowx<M && nowy>=0 && nowy<N && !check[nowx][nowy] && arr[nowx][nowy] == 1) {
				check[nowx][nowy] = true;
				dfs(nowx, nowy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //가로
			N = Integer.parseInt(st.nextToken()); //세로
			K = Integer.parseInt(st.nextToken()); //배추 위치 개수
			
			arr = new int[M][N];
			check = new boolean[M][N];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}

			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
	
		System.out.println(sb);
	}

}