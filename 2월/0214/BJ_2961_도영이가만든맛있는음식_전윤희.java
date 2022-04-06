package com.ssafy.im;

import java.util.*;

// 도영아 걍 배민써라
public class BJ_2962_도영이가만든맛있는음식 {

	static int N;
	static int food = Integer.MAX_VALUE;
	static int[] S; // 신맛
	static int[] B; // 쓴맛
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 재료의 개수

		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			S[i] = in.nextInt();
			B[i] = in.nextInt();
		}

		subset(0);
		System.out.println(food);

	}

	private static void subset(int cnt) {
		// 기저조건
		if (cnt == N) {
			int sour = 1; // 적어도 재료를 하나는 사용해야함
			int bitter = 0;
			int select = 0;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) { // 재료 고른 것
					sour = sour * S[i]; // 신맛
					bitter = bitter + B[i]; // 쓴맛
					select++;
				}
			}

			if (select > 0) {
				food = Math.min(food, Math.abs(sour - bitter));
			}

			return;
		}

		// 유도파트
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);

	}

}
