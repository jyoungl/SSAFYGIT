package 기타;

import java.io.*;
import java.util.*;

public class BJ_16173_점프왕쩰리 {
	static int N;
	static int[][] arr;
	static boolean[][] isVisited;
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N][N];
		isVisited = new boolean[N][N];

		// 점프가능범위가 적힌 게임판
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.nextInt();
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (isVisited[i][j])
//					continue;
//				goJump(i, j);
//			}
//		}

		goJump(0, 0); // 시작점 (0,0)
		System.out.println("Hing");
	}

	private static void goJump(int r, int c) {
		isVisited[r][c] = true;
		if (arr[r][c] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		int jump = arr[r][c];
		for (int d = 0; d < 2; d++) {
			int nr = r + dr[d] * jump;
			int nc = c + dc[d] * jump;

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (isVisited[nr][nc])
				continue;
			goJump(nr, nc);
		}
	}

}
