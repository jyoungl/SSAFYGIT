package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1987_알파벳 {

	static int R; // 행
	static int C; // 열
	static int max; // 최대 이동 거리
	static char[][] arr; // 알파벳 저장할 배열 변수
	static boolean[] visited; // 이동 시 지나온 알파벳과 새로 지날 알파벳이 달라야 하므로 이를 저장할 배열 변수

	// 상하좌우 4방탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		max = 1; // 말이 지나는 칸은 좌측 상단의 칸도 포함되므로 1부터 시작

		arr = new char[R][C];
		visited = new boolean[26]; // A - Z 알파벳 갯수 : 26개

		// 배열초기화
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// go 메서드 호출하면 자동으로 (0, 0)에 말을 두게 되므로
		// 해당 칸의 알파벳을 사용한 것으로 간주
		visited[arr[0][0] - 'A'] = true; // 알파벳 'A'를 빼주어 A~Z를 0~25로 관리
		go(0, 0, 1);

		System.out.print(max);

	}

	/**
	 * @param r   : 현재 말이 위치하는 행
	 * @param c   : 현재 말이 위치하는 열
	 * @param cnt : 말이 이동한 횟수
	 */
	private static void go(int r, int c, int cnt) {

		// go() 재귀함수에서는 기저조건을 따로 명시하지 않는이유 :
		// 아래 for문에서 특정 조건(배열 범위를 벗어나거나, 이미 해당 알파벳을 쓴 경우)에서 continue가 발생
		// 따라서 반복문을 통과해버리는 경우 그 자체가 기저조건이기 때문이다.
		max = Math.max(max, cnt); // 매 재귀마다 max값 갱신

		for (int i = 0; i < 4; i++) { // 상하좌우 4번 반복

			int nx = r + dr[i]; // 말이 새로 이동할 행
			int ny = c + dc[i]; // 말이 새로 이동할 열

			// 배열의 범위를 벗어나는 경우
			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;

			// 접근하려는 칸의 알파벳을 이미 사용한 경우 다른 경로 탐색
			if (visited[arr[nx][ny] - 'A'])
				continue;

			// 유도파트
			// 이 부분으로 오기 전 반복문이 종료되면 말이 움직이지 못한다는말이므로 위는 자연스레 기저조건이 됨

			visited[arr[nx][ny] - 'A'] = true; // 새로 움직인 칸의 알파벳 사용
			go(nx, ny, cnt + 1); // 재귀호출
			visited[arr[nx][ny] - 'A'] = false; // 재귀를 다 돌고 난 후, 처음 방향과는 다른 방향으로 돌기 위해 알파벳을 미사용으로 되돌림

		}

	}

}
