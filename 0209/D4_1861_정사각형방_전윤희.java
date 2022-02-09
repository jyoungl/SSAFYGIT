package com.ssafy.im;

//자바스럽지는 않지만, 이렇게 통으로 import 해놓으면 제출 시 따로 주석처리 해야하는 번거로움 감소
import java.util.*;
import java.io.*;

//배열
//DFS (0210 배움)
//트리
public class D4_1861_정사각형방 {

	static int T;
	static int N; // NxN
	static int[][] map;

	// 상하좌우 4방탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new FileInputStream("input_D4_1861_정사각형방.txt"));
		//Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			map = new int[N][N];

			// 읽어오기 (배열 초기화)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = in.nextInt();
				}
			}

			// 로직
			int ans = 0;
			int max = 0;
			int save = N * N; //최대 돌 수 있는 횟수
			int search = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					search = SEARCH(map, i, j, 1);

					if (search > max) {
						save = map[i][j];
						max = search;
					} else if (search == max) { // search와 max가 같다면 전에 숫자가 더큰지 작은지를 확인하여 작은 수를 save 함
						if (map[i][j] < save) {
							save = map[i][j];
						}
					}
				}
			}

			System.out.println("#" + tc + " " + save + " " + max);

			// 초기화
			save = N * N;
			search = 1;
			max = 0;
		}

	}

	// 메서드 분리 설계 - 보충수업에서 배운 것 응용
	// 재귀
	private static int SEARCH(int[][] arr, int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr, nc)) {
				continue;
			}

			// 유도파트
			if (map[r][c] + 1 == map[nr][nc]) { // 상하좌우에 현위치의 숫자보다 +1크면 SEARCH 함수를 선언해 재귀
				cnt = cnt + SEARCH(map, nr, nc, cnt);
			}
		}
		return cnt;
	}

	// 배열 범위 조건 따로 메서드 분리
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
