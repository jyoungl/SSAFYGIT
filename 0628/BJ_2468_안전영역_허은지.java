package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_2468_안전영역2 {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int ans = Integer.MIN_VALUE;

		for (int k = min-1; k < max; k++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] > k && !visited[i][j]) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			
			ans = Math.max(cnt, ans);
		}
		
		System.out.println(ans);

	}

	private static void dfs(int x, int y, int rain) {
		visited[x][y] = true;

		for(int i = 0; i<4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			if(r<0 || r>=N || c<0 || c>=N || arr[r][c] <= rain || visited[r][c]) continue;
			dfs(r, c, rain);
		}
		
	}

}