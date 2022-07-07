package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_21736_헌내기는친구가필요해 {
	static int N, M, cnt;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		dfs(x, y);
		
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);

	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if(arr[x][y] == 'P') {
			cnt++;
		}
		for (int k = 0; k < 4; k++) {
			int i = x + dx[k];
			int j = y + dy[k];
			if(i<0 || i>=N || j<0 || j>=M || visited[i][j] || arr[i][j] == 'X') continue;
			dfs(i, j);
		}
		
	}

}
