package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_1670_정상회담2 {
	static final int MOD = 987654321; // 나누는 수
	static long[] dp = new long[10001];

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // 정상 회담에 참가한 사람의 수

		System.out.println(hand(N));
	}

	// 재귀
	static long hand(int N) {

		if (N == 0) {
			return 1;
		}

		if (N == 2) {
			return dp[2] = 1;
		}

		if (dp[N] > 0) {
			return dp[N];
		}

		long temp = 0;

		for (int i = 1; i < N; i += 2) {
			temp += hand(i - 1) * hand(N - (i + 1));
			temp %= MOD;
		}

		return dp[N] = temp;
	}
}