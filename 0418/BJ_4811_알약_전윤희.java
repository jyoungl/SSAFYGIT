package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_4811_알약 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[31]; // 약의 개수 N ≤ 30

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		while (true) {
			int N = in.nextInt();

			if (N == 0) {
				break;
			}

			for (int i = 3; i <= 30; i++) {
				long cnt = 0;

				for (int j = 0; j < i; j++) {
					cnt += dp[j] * dp[i - 1 - j];
				}

				dp[i] = cnt;
			}

			sb.append(dp[N] + "\n");
		}

		System.out.println(sb);
	}

}