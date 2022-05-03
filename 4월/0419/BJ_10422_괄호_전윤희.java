package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_10422_괄호 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		long[] dp = new long[5001]; //  문자열의 길이 L (1 ≤ L ≤ 5000) 
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 2; i <= 2500; i++) { // 괄호는 짝수만 유효
			for (int j = 0; j <= i - 1; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i * 2] %= 1000000007L;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int L = in.nextInt();
			sb.append(dp[L] + "\n");
		}
		System.out.println(sb);
	}
}