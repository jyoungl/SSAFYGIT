package com.dfsbfs;

import java.io.*;
import java.util.*;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오. 
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다. 
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 * 
 * 2(세로), n(가로)(1에서 1,000)
 * 
 * 123 더하기 응용(자연수의 분할) 가로 2를 채울 수 있는 방법) 0+2, 1+1 새로 n을 채울수 있는 방법) n = 1+1+1+1+···+1, 2+1+1+···+1, 4+1+1+···+1, ···
 * 
 * 어제 stack으로 풀다가 망했고, 어제 나열해서 푼 은지님처럼 나열 해보자
 */

public class BJ_11726_2xn타일링 {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("docs/input_11726.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 2xn

		int[] dp = new int[n + 2]; // 숫자와 숫자 순서를 맞추기 위해 배열 인덱스 0번 버림

		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n] % 10007);
	}
}
