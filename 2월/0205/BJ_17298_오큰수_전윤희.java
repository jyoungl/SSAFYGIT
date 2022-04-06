package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스택방식 이해가 안가서 브루트포스 방식처럼 풀었음
//근데 시간초과 남
//스터디 코드 설명할때 (스택부분) 잘 들어보기

public class stack_17298_오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T]; // 원배열
		int arrNew[] = new int[T]; // 오큰수 저장배열

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < T; i++) {
			for (int j = i + 1; j < T; j++) {
				if (arr[i] - arr[j] < 0) {
					arrNew[i] = arr[j];
					// return;
					break;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			if(arrNew[i] == 0) { //배열 초기화값 0인 경우는 오큰수 없는 경우
				System.out.print("-1 ");
			} else {
				System.out.print(arrNew[i]+" ");
			}
		}
	}
}