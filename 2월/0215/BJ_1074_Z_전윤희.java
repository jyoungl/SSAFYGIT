package com.ssafy.im;

import java.util.*;
import java.io.*;

// 재귀
public class BJ_1074_Z {

	static int N; // 2의 N승
	static int R, C; // 행과 열
	static int n;
	static int count = 0; // 방문 순서

	// Z 모양
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// Math.pow(a, b)는 double 을 리턴하므로 강제형변환 필요
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken())); // 2의 N승
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		recursive(N, 0, 0);
	}

	private static void recursive(int n, int row, int col) {
		// 기저조건
		if (n == 2) { // 2×2가 기본이니까
			for (int i = 0; i < 4; i++) {
				int r = row + dr[i];
				int c = col + dc[i];

				if (r == R && c == C) {
					System.out.println(count);
					return;
				}
				count++;
			}
			return;
		}

		// 유도파트
		recursive(n / 2, row, col);
		recursive(n / 2, row, col + n / 2); // 우측
		recursive(n / 2, row + n / 2, col); // 하단
		recursive(n / 2, row + n / 2, col + n / 2); // 대각선하단

	}

}
