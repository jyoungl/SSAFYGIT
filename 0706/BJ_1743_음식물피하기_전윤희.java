package 기타;

import java.io.*;
import java.util.*;

public class BJ_1743_음식물피하기 {
	static int R, C, tempR, tempC;

	static int[][] arr;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int cnt; // 쓰레기 덩어리
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		int K = in.nextInt(); // 음식물 쓰레기 수

		arr = new int[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];
		for (int n = 0; n < K; n++) {
			tempR = in.nextInt();
			tempC = in.nextInt();
			arr[tempR][tempC] = 1;
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (!visited[i][j] && arr[i][j] == 1) { // 한번도 방문하지 않았고, 음식물쓰레기가 있으면 탐색 시작
					// cnt++;
					cnt = 0;
					bfs(i, j);
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));

		while (!q.isEmpty()) {
			cnt++;
			Pos temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];

				if (nr < 0 || nc < 0 || nr > R || nc > C)
					continue;

				if (!visited[nr][nc] && arr[nr][nc] == 1) {
					// while문을 돌기 때문에 방문처리 배열 true 처리 필수
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			}
		}
	}

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
