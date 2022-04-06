package com.ssafy;

import java.util.*;
import java.io.*;

public class BJ_2740_행렬곱셈 {

	static int[][] pre;
	static int[][] post;
	static int[][] multiple;

	static int N, M, K;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();

		pre = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				pre[i][j] = in.nextInt();
			}
		}

		M = in.nextInt();
		K = in.nextInt();
		post = new int[M][K];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				post[i][j] = in.nextInt();
			}
		}

		multiple = new int[N][K];
		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				temp = 0;
				for (int m = 0; m < M; m++) {
					temp += pre[i][m] * post[m][j];
				}
				multiple[i][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(multiple[i][j]+" ");
			}
			System.out.println();
		}
	}

}
