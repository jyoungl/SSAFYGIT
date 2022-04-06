package com.ssafy;

import java.io.*;
import java.util.*;

/*
 * 이분탐색
 * 정렬되어 있는(이분 탐색의 주요 조건) 배열에서 데이터를 찾으려 시도할 때, 
 * 순차탐색처럼 처음부터 끝까지 하나씩 모든 데이터를 체크하여 값을 찾는 것이 아니라
 * 탐색 범위를 절반씩 줄여가며 찾아가는 Search 방법이다.
 */
public class BJ_1920_수찾기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N]; //4 1 5 2 3

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분탐색은 정렬을 필수로 한다
		Arrays.sort(arr1);

		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];

		st = new StringTokenizer(br.readLine());

		// 이분 탐색
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());

			int maxIndex = arr1.length - 1;
			int minIndex = 0;
			int middleIndex;

			while (true) {
				if (minIndex > maxIndex) {
					bw.append("0\n");
					break;
				}

				middleIndex = (maxIndex + minIndex) / 2;

				if (arr1[middleIndex] == arr2[i]) {
					bw.append("1\n");
					break;
				}

				if (arr1[middleIndex] < arr2[i]) {
					minIndex = middleIndex + 1;
				} else if (arr1[middleIndex] > arr2[i]) {
					maxIndex = middleIndex - 1;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
