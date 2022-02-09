package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_1210_Ladder1 {

	static int trashValue; // input 파일 보고 테스트케이스 갯수 아니까
	static int[][] field;
	static boolean[][] checked;

	/**
	 * 계속 output 값이 이유 : 맨 아래서부터 훑고 올라가므로 탐색시 '상'탐색을 가장 나중에 해줘야 한다. 
	 * 예를 들면
	 * 0 1 0 
	 * 1 1 1 인 경우, ㅗ 모양의 정중앙의 1(위치상 [1][1])은 사다리타기의 규칙상 위로 가지 않고 좌/우로 갈 수 있기 때문
	 */
	// goal 지점에서 start 부분을 찾아 거슬러 올라가므로, 좌, 우, 상 탐색
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new FileInputStream("input_D4_1210_Ladder1.txt"));
		//Scanner in = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			trashValue = in.nextInt();
			field = new int[100][100];
			checked = new boolean[100][100]; // 왔던 길 체크

			// 사다리판 배열 초기화
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					field[i][j] = in.nextInt();
				}
			}

			for (int i = 0; i < 100; i++) {
				if (field[99][i] == 2) { // 사다리판 맨 아래줄에서 2는 도착지점. 지정된 도착점(2)에 대응하는 출발점 : start
					// 2(도착점)인 지점에서부터 그에 대응되는 시작점을 찾아 거슬러 올라가보자고
					int r = 99;
					int c = i;
					int nr = 100;
					int nc = 100;

					while (nr != 0) {
						for (int j = 0; j < 3; j++) { // 좌, 우 , 상 탐색
							nr = r + dr[j];
							nc = c + dc[j];
							if (!check(nr, nc)) // 배열 밖으로 나가면 안되니까범위 체크
								continue;
							if (field[nr][nc] == 1 && !checked[nr][nc]) {
								// if문 안에서 false 있으면 안돌아가더라.
								// !checked[nr][nc] 가 false(초기값) 를 true로 완전히 변화시켜주는게 아니라, 저 조건에서만 잠시 바꿔주는 것
								r = nr;
								c = nc;
								checked[nr][nc] = true; // 방문한 곳. 이것이 완전히 초기값 false를 true로 바뀌어주는 것
								break;
							}
						}
					}

					sb.append("#" + tc + " " + nc + "\n");

				}
			}

			// System.out.println("#" + tc + " " + nc);
		}
		System.out.println(sb);

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}

}
