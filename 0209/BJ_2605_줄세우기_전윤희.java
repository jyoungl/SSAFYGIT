package com.im.baekjoon;

import java.util.*;
import java.io.*;

/**
 * 0 1 2 3 4 = index 
 * 1 2 3 4 5 = 순서
 * 
 * 불편해서 메모리 낭비 감수 
 * 0 1 2 3 4 5 = 배열 index 
 * x 1 2 3 4 5 = 순서(i)
 * .~0 1 2 3 4 = pick 최대(왜냐하면 내가 arr[0]은 쓰지 않으니까)
 */
public class BJ_2605_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N명의 학생
		int[] arr = new int[N + 1]; // 최종적으로 학생들의 줄 순서. 순서 1 = 배열의 인덱스 0 ← 불편하므로 메모리(arr[0]) 그냥 낭비하자

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int pick = Integer.parseInt(st.nextToken());

			if (pick == 0) { // pick 이 0이면 자기자리
				arr[i] = i;
			} else { // pick = 1, 2, ···, (i-1) ← pick 만큼 앞으로 가서 선다.
				for (int j = i; j >= i - pick; j--) {
					arr[j] = arr[j - 1]; // 선택 배열의 앞부분이 뒤로 밀림
				}
				arr[i - pick] = i;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
