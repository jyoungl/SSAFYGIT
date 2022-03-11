package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_1932_정수삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 삼각형 높이

		int[][] arr = new int[N][N];
		                  
		for (int i = N; i > 0; i--) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < (N-i + 1); j++) {
				arr[N-i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.println(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int[][] sum = new int[N][N];
		// 배열 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum[i][j] = arr[i][j];
			}
		}
		
		int max = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					sum[i+1][j] = arr[i+1][j] + arr[i][k];
					max = Math.max(max, sum[i+1][j]);
				}
				sum[i+1][j] = max;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
		
		int finalCost = 0; 
		for (int j = 0; j < N; j++) {
			finalCost = Math.max(finalCost, sum[N-1][j]);
		}

		System.out.println(finalCost);
	}
}