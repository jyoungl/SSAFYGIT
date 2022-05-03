package com.ssafy.A;

import java.io.*;
import java.util.*;

public class BJ_9465_스티커 {
	static int T;
	static int col;
	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			col = Integer.parseInt(br.readLine());

			sticker = new int[2][col+1];
			dp = new int[2][col+1];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= col; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			for (int k = 2; k <= col; k++) {
				dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + sticker[0][k];
				dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + sticker[1][k];
			}
			System.out.println(Math.max(dp[0][col], dp[1][col]));
		}

	}

}
