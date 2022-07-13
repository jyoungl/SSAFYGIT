package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_13565_침투 {
	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(arr[0][i] == 0 && !visited[0][i]) dfs(0, i);
		}
		
		System.out.println("NO");

	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		if(i == M-1) {
			System.out.println("YES");
			System.exit(0);
		}
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < 0 || x >= M || y < 0 || y >= N || visited[x][y] || arr[x][y] == 1) continue;
			dfs(x, y);
		}
		
	}

}
