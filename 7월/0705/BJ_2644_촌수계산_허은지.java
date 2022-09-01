package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_2644_촌수계산 {
	static int n, m, end;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = arr[y][x] = 1;
		}
		
		dfs(start, 0);
		
		System.out.println(-1);

	}

	private static void dfs(int i, int cnt) {
		visited[i] = true;
		
		if(i == end) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		for (int k = 1; k <= n; k++) {
			if(visited[k] || arr[i][k] == 0) continue;
			dfs(k, cnt+1);
		}
		
	}

}
