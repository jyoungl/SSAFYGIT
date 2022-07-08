package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1926_그림 {
	static int n, m, size;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(visited[i][j] || arr[i][j] == 0) continue;
				size = 0;
				dfs(i, j);
				max = Math.max(max, size);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);

	}

	private static void dfs(int i, int j) {
		size++;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || arr[x][y] == 0) continue;
			dfs(x, y);
		}
		
	}

}
