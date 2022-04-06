package com.dfsbfs;

import java.io.*;
import java.util.*;

public class BJ_2193_이친수 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt(); // N자리 이친수
		long[] dp = new long[N+3]; // N자리와 배열인덱스 순서를 같게 하기 위함
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		//dp[4] = 3;
		//dp[5] = 5;
		
		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[N]);

	}

}
