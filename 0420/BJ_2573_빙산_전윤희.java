package com.ssafy.A;

import java.io.*;
import java.util.*;

/**
 * 메모리 | 시간
 * BufferedReader 21768KB | 376ms
 * Scanner		  92256KB | 940ms
 */
public class BJ_2573_빙산 {
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int R, C; // 행과 열
	static int year = 0; // 빙산이 분리되는 최초의 시간(년)

	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//R = in.nextInt();
		R = Integer.parseInt(st.nextToken());
		//C = in.nextInt();
		C = Integer.parseInt(st.nextToken());

		// 배열 초기화
		map = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				//map[i][j] = in.nextInt();
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// visited 배열 초기화 (이거 안해주면 오류남)
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					visited[i][j] = false;
				}
			}

			int iceberg = 0; // 빙산이 있는지 없는지를 알기위해 변수 생성
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0 && !visited[i][j]) { // 빙산이 존재하고 방문하지 않았다면
						dfs(i, j);
						iceberg++; // DFS 함수 실행할 때 마다 하나의 덩어리로 인식하여 갯수를 더하기 때문
						if (iceberg >= 2) { // 2개 이상의 덩어리로 분리되었을 경우
							System.out.println(year);
							return;
						}
					}
				}
			}

			// 만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
			if (iceberg == 0) { // 모든 빙산이
				System.out.println(0);
				return;
			}
			year++;

		} // while end
	} // main end

	static void dfs(int r, int c) {
		visited[r][c] = true; // 방문처리

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;

			if (!visited[nr][nc]) { // 방문하지 않았다면
				if (map[nr][nc] <= 0) {// 인접한 물의 칸 만큼 빼기
					map[r][c] -= 1;
				} else
					dfs(nr, nc);
			}

		} // for end
	}
}