package 기타;

import java.io.*;
import java.util.*;

/**
 * Scanner			204152KB | 1504ms
 * BufferedReader	50332KB  | 352ms
**/

public class BJ_1926_그림 {
	static int R, C;
	static int[][] paper;
	static boolean[][] isVisited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int painting; // 그림의 갯수
	static int cnt; // 그림의 크기
	static int ans; // 그림의 최대크기

	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
//		R = in.nextInt();
		R = Integer.parseInt(st.nextToken());
//		C = in.nextInt();
		C = Integer.parseInt(st.nextToken());

		paper = new int[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
//				paper[i][j] = in.nextInt();
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		painting = 0;
		ans = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isVisited[i][j] && paper[i][j] == 1) {
					cnt = 0;
					painting++;
					DFS(i, j);
				}
				ans = Math.max(cnt, ans);
			}
		}
		sb.append(painting + "\n" + ans);
		System.out.println(sb);
	}

	private static void DFS(int r, int c) {
		isVisited[r][c] = true;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;

			if (isVisited[nr][nc])
				continue;

			if (paper[nr][nc] == 1) {
				isVisited[nr][nc] = true;
				DFS(nr, nc);
			}
		} // for End
	}

}
