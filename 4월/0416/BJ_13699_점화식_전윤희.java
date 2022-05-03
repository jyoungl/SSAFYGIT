package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_13699_점화식 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		long[] dp = new long[36];

		dp[0] = dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			long sum = 0;
			for (int j = 0; j < i / 2; j++)
				sum += dp[j] * dp[(i - 1) - j];

			sum = sum * 2;
			dp[i] = (i % 2 == 0) ? sum : sum + dp[i / 2] * dp[i / 2]; 
			
//			//(int) Math.pow(dp[i / 2], 2) 는 왜 안되지? 2147483647 (정수형 초과)
//			System.out.println("dp[i / 2] * dp[i / 2]: "+dp[i / 2] * dp[i / 2]);
//			System.out.println("(int) Math.pow(dp[i / 2], 2): "+(int) Math.pow(dp[i / 2], 2));
//			System.out.println();
		}

		System.out.println(dp[n]);

	}
}
