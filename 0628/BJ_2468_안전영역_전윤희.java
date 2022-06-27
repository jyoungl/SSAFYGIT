package 기타;

import java.io.*;
import java.util.*;

public class BJ_2468_안전영역 {
	static int N;
	static int[][] place;
	static boolean[][] isVisited;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		// 비의 양 임계치 초기화
		place = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());

				if (hm.containsKey(place[i][j]) == true) {
					hm.put(place[i][j], hm.get(place[i][j]) + 1);
				} else {
					hm.put(place[i][j], 1);
				}
			}
		}

		int cnt = 0;
		int max = 1; // 최소 강수량. 예를 들어 모든 지역의 비의 양 임계치 값이 같을 수도 있기 때문
		for (Integer key : hm.keySet()) {
			if (max < cnt)
				max = cnt;

			isVisited = new boolean[N][N];
			int rain = key;
			cnt = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (isVisited[j][k])
						continue;
					if (place[j][k] <= rain)
						continue;

					cnt++;
					go(j, k, rain);
				}
			}
		}

		System.out.println(max);
	}

	private static void go(int r, int c, int rain) {
		isVisited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 범위초과하면 리턴
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			// 방문했으면 리턴
			if (isVisited[nr][nc])
				continue;

			if (place[nr][nc] > rain) {
				isVisited[nr][nc] = true;
				go(nr, nc, rain);
			}
		}

	}
}
