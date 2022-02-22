package lv24_DFS와BFS;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 배추를 심은 배추밭의 가로 길이 M 세로 길이 N 배추가 심어져 있는 위치의 개수 K
 * 3. K줄 동안 배추의 위치 X Y
 * 출력
 * 배추흰지렁이 마리 수
 * 
 * >> 지렁이는 인접한 다른 배추로 이동 가능
 * >> 지렁이를 최소로 사용
 * >> dfs, 사방 탐색
 */
public class s2_1012_유기농배추 {
	static int M, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[M][N];
			boolean[][] visited = new boolean[M][N];
			
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			
			int ans = 0;
			
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j, arr, visited);
						ans++;
					}
				}
			}	
			sb.append(ans).append("\n");	
		}

		System.out.println(sb);
	}

	private static void dfs(int x, int y, int[][] arr, boolean[][] visited) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		visited[x][y]=true;
		for(int i = 0; i<4; i++) {
			int r = x+dx[i];
			int c = y+dy[i];
			if(r<0 || r>=M || c<0 || c>=N) continue;
			if(arr[r][c]==1 && !visited[r][c]) {
				dfs(r, c, arr, visited);
			}
		}
		
	}

}
