package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_2583_영역구하기 {
	static int M, N, K, size;
	static boolean[][] arr, visited;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[M][N];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					arr[i][j] = true;
				}
			}
		}

		int cnt = 0;
		visited = new boolean[M][N];
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!arr[i][j] && !visited[i][j]) {
					dfs(i, j);
					cnt++;
					list.add(size);
				}
			}
		}
		
		Collections.sort(list);

		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	private static void dfs(int x, int y) {
		size++;
		
		visited[x][y] = true;

		for(int i = 0; i<4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			if(r<0 || r>=M || c<0 || c>=N || arr[r][c] || visited[r][c]) continue;
			dfs(r, c);
		}

		
	}

}