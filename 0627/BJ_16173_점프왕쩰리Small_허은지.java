package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_16173_점프왕쩰리Small {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1}, dy = {1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println("Hing");

	}

	private static void dfs(int i, int j) {
		if(arr[i][j] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		
		for (int k = 0; k < 2; k++) {
			int x = i + dx[k] * arr[i][j];
			int y = j + dy[k] * arr[i][j];
			if(x>=N || y>=N || visited[x][y]) continue;
			
			visited[x][y] = true;
			dfs(x, y);
		}
		
	}

}
