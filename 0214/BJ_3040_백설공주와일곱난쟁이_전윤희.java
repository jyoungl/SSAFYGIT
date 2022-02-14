package com.ssafy.im;

import java.util.*;
import java.io.*;

// 교수님께서 저번에 주셔서 풀었던 IM문제 일곱난쟁이와 똑같음
public class BJ_3040_백설공주와일곱난쟁이 {

	static int[] kids;
	static int[] realKids;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		kids = new int[9];
		realKids = new int[7];

		for (int i = 0; i < 9; i++) {
			kids[i] = in.nextInt();
		}

		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		// 기저조건
		if (cnt == 7) {
			int sum = 0; // 난쟁이들의 모자에 적혀있는 숫자들의 합을 저장하는 변수
			for (int i = 0; i < 7; i++) {
				sum = sum + realKids[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(realKids[i]);
				}
				return;
			}
			return;
		}

		// 유도파트
		for (int i = start; i < 9; i++) {
			realKids[cnt] = kids[i];
			combination(cnt + 1, i + 1);
		}
	}

}
