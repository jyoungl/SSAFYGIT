package com.im.baekjoon;

import java.io.*;
import java.util.*;

// 101로 사이즈를 맞춘 이유 : 100 정사이즈로 풀면, 색종이가 좌표평면 축에 달라 붙었을 때, 그 경우 주변에 0이 검색되지 않음
public class BJ_2567_색종이2 {
	static int N; // 색종이의 개수
	static int[][] plane = new int[101][101]; // 0으로 초기화 되어있음
	static int[][] pos; // 좌표

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		pos = new int[N][2]; // [][0] : x좌표, [][1] : y좌표

		// 좌표 초기화
		for (int i = 0; i < N; i++) {
			pos[i][0] = in.nextInt(); // x좌표
			pos[i][1] = in.nextInt(); // y좌표
			// System.out.println(pos[i][0]+" "+pos[i][1]);

			// 사각형 1로 채워넣기
			for (int j = pos[i][0]; j < pos[i][0] + 10; j++) { // 한변의 길이가 10
				for (int k = pos[i][1]; k < pos[i][1] + 10; k++) {
					plane[j][k] = 1;
				}
			}
		}

		// 색종이 넓이 문제 응용 (1로 넓이 체크했던 것)
		// 사각형 1로 채워넣기
		// 1 주변을 사방탐색을 통해 주변의 0을 체크하고
		// 주변 0이 두개면, 모서리부분이니까 2번 세주고
		// 주변 0이 한개면, 1번 세준다
		// 주변에 0이 하나도 없으면(1만 있으면) 사각형 안이니까 세어주지 않는다
		
		// 상우하좌(시계방향)
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (plane[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < 101 && nc >= 0 && nc < 101) {
							if (plane[nr][nc] == 0) {
								count++;
							}
						}
					}
				}
			}
		}

		System.out.println(count);
	}

}
