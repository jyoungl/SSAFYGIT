package com.ssafy.im;

import java.util.*;
import java.io.*;

public class JO_1828_냉장고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 화학물질 개수
		int[][] arr = new int[N][2]; // 화학물질을 보관할 최저온도와 최고온도를 저장하기 위한 배열 변수 생성

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); // 보관 가능한 최저온도
			arr[i][1] = Integer.parseInt(st.nextToken()); // 보관 가능한 최고온도
		}

		// 2차원배열 정렬
		// [][0] 기준 정렬 (0열이 오름차순으로 정렬)
		/**
		 * 0열 1열 
		 * -15 5 
		 * -10 36 
		 *  10 73 
		 *  27 44
		 */
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
				// 음수 또는 0이면 객체의 자리가 그대로 유지, 양수인 경우에는 두 객체의 자리가 바뀜
			}
		});
		
		// 프린트해서 확인
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		int refrigerator = 0; // 최소 냉장고 개수 count		
		int i = 0; 
		int j = 0;
		
		// N개중 제일 낮은 보관최저온도를 가진 화학물질의 보관최고온도를 다음 화학물질의 보관최저온도와 비교
		// 단, 처음에 냉장고를 0으로 설정했으므로 냉장고 +1
		// (i+1번째 화학물질)보관최저온도 <= (i번째 화학물질)보관최고온도 <= (i+1번째 화학물질)보관최고온도 이면 냉장고 추가 X
		// (i번째 화학물질)보관최고온도 < (i+1번째 화학물질)보관최저온도 이면 냉장고 +1
		while (i < N) {
			int end = arr[i][1]; 

			a:for (j = i + 1; j < N; j++) {
				if (end < arr[j][0]) {
					break a; // 순간 헷갈려서 반복문 라벨링했음 
				}
				end = Math.min(end, arr[j][1]);
			}
			i = j;
			refrigerator++;
		}
		System.out.println(refrigerator);

	}

}
