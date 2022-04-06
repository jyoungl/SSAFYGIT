package com.im.baekjoon;

import java.util.*;
import java.io.*;

public class BJ_3060_욕심쟁이돼지 {
	static int T; // 테스트케이스
	static int total; // 하루에 배송되는 총 사료의 양
	static int[] pig;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		pig = new int[7]; // 돼지 순서 1부터 시작하므로 배열 인덱스 0번은 버림

		for (int t = 0; t < T; t++) {
			int sum = 0; // 사료 총합
			int day = 1; // 초기화(욕심쟁이 돼지들 먹이 줄 수 있는 최대 날짜 수)
			
			total = Integer.parseInt(br.readLine()); // 하루에 배송되는 사료양
			//System.out.println(total);
			
			st = new StringTokenizer(br.readLine(), " ");
			// 배열 초기화
			for (int i = 1; i < pig.length; i++) {
				pig[i] = Integer.parseInt(st.nextToken());
				sum = sum + pig[i];
			}
			//System.out.println(sum);

			while (true) {
				if (sum <= total) {
					sum = 3 * sum;
					day++;
				} else
					break;
			}
			System.out.println(day);
		}
	}

}
