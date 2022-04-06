package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_9461_파도반수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int tc = 0; tc < T; tc++) {
			
			/*
			 * int로 하면 <틀렸습니다> 나온다
			 * int arr[] = new int[101]; 
			 */
			long arr[] = new long[101]; // 배열인덱스 0번 버림

			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			arr[4] = 2;
			arr[5] = 2;
			for (int i = 6; i <= 100; i++) {
				arr[i] = arr[i - 2] + arr[i - 3];
			}

			int N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}
}