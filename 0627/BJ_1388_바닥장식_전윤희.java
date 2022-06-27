package 기타;

import java.io.*;
import java.util.*;

public class BJ_1388_바닥장식_BFS {
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int R, C;
	static char[][] floor;
	static boolean[][] isVisited;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static Queue<Point> q;

	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		floor = new char[R][C];
		isVisited = new boolean[R][C];
		q = new LinkedList<>();
		cnt = 0;

		// charAt() 사용
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				floor[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isVisited[i][j]) { // 방문하지 않았으면
					bfs(new Point(i, j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	private static void bfs(Point point) {
		isVisited[point.r][point.c] = true;
		q.add(point);

		while (!q.isEmpty()) { // 큐가 빌 때까지
			Point p = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;

				if (floor[p.r][p.c] == '-') {
					if (floor[p.r][nc] == floor[p.r][p.c] && !isVisited[p.r][nc]) {
						q.offer(new Point(p.r, nc));
						isVisited[p.r][nc] = true;
					}
				} else { // floor[p.r][p.c] == '|'
					if (floor[nr][p.c] == floor[p.r][p.c] && !isVisited[nr][p.c]) {
						q.offer(new Point(nr, p.c));
						isVisited[nr][p.c] = true;
					}
				}

			}
		}
	}

}
