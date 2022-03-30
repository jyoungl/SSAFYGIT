package com.ssafy.A;

import java.io.*;
import java.util.*;

public class BJ_11052_카드구매하기 {
	static int N; // 카드 개수
	static int[] cost;
	static float max, temp;
	static int max_idx = 1001;
	static int mod;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		cost = new int[N + 1];
		for (int i = 1; i <= N; i++) { // 배열 인덱스와 카드개수 일치
			cost[i] = in.nextInt();
		}
		
		System.out.println(calculate(N, 0));
	}

	private static int calculate(int mod, int money) {
		if((mod % max_idx) == 0) return money;
		
		for (int i = 1; i <= N; i++) { // 배열 인덱스와 카드개수 일치
			temp = cost[i] / i;
			if (max < temp) {
				max_idx = i;
				max = temp;
			}
		}
		mod = N % max_idx;
		money = cost[max_idx] * (N/max_idx);
		N = mod;
		return money;
		
	}

}
