package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_1463_1로만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];

		// 거꾸로 타고 올라가기
		// arr[1] = 0
		// arr[2] = 2/2 or 2-1
		// arr[3] = 3/3
		// arr[4] = 4/2 2/2
		// arr[5] = 이미 [4]까지가 가장 최솟값만 저장된 상태이므로 +1 이 최선
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + 1;

			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			}
			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
		}

		System.out.println(arr[N]);

	}

}
