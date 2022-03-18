package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_10816_숫자카드2 {
	static int N, M;
	static int[] arr1;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = in.nextInt(); // 10
		
		// <각 숫자를 인덱스로 하는 숫자통에 숫자 담기>
		// 오류 1) java.lang.ArrayIndexOutOfBoundsException : 배열 인덱스가 음수일 때
		// 오류 2) 백준 내에서 ArrayIndexOutOfBoundsException : -10000000에서 10000000사이의 숫자는 20000001개이다
		// -1에서 1 사이의 정수는 -1, 0, 1로 3개니까
		arr1 = new int[20000001]; // 숫자카드 : -10000000 이상 10000000 이하
		
		for (int i = 0; i < N; i++) { // N번 반복
			arr1[in.nextInt()+ 10000000]++; // 각 숫자의 통에 담기
		}

		M = in.nextInt();
		for (int i = 0; i < M; i++) {
			sb.append(arr1[in.nextInt()+ 10000000]).append(" ");
		}
		
		System.out.println(sb);
	}
}
