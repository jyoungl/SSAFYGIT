package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1743_음식물피하기 {
	static int N, M, K, cnt;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 1;
		}
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					ans = Math.max(ans, cnt);
				}
			}
		}
		
		System.out.println(ans);

	}

	private static void dfs(int i, int j) {
		cnt++;
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || arr[x][y] == 0) continue;
			dfs(x, y);
		}
		
	}

}
