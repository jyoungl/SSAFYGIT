package 스터디숙제;

import java.io.*;
import java.util.*;

public class BJ_1189_컴백홈 {
	static int R, C, K;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 출발-도착 거리

		arr = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i] = s.toCharArray();
			}
		}

		cnt = 0;

		visited[R - 1][0] = true;
		DFS(R - 1, 0, 1);

		System.out.println(cnt);
	}

	private static void DFS(int r, int c, int k) {
		if (r == 0 && c == C - 1 && k == K) {
			cnt++;
			return;
		}
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (visited[nr][nc])
				continue;
			if (arr[nr][nc] == '.') {
				visited[nr][nc] = true;
				DFS(nr, nc, k++);
			}
		}
	}

}
