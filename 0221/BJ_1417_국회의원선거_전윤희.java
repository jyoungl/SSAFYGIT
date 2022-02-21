package com.im.baekjoon;

import java.util.*;
import java.io.*;

// 완전탐색
public class BJ_1417_국회의원선거 {

	static int N; // 후보의 수
//	static int candidate1; // 기호 1번을 찍으려고 하는 사람의 수 (기호 1번: 다솜)
//	static int candidate2; // 기호 2번을 찍으려고 하는 사람의 수
//	static int candidate3; // 기호 3번을 찍으려고 하는 사람의 수
	static int[] candidate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		candidate = new int[N + 1]; // 순서 직관적으로 알기위해 배열 인덱스 0 버림

		for (int i = 1; i <= N; i++) {
//			candidate1 = Integer.parseInt(br.readLine());
//			candidate2 = Integer.parseInt(br.readLine());
//			candidate3 = Integer.parseInt(br.readLine());
			candidate[i] = Integer.parseInt(br.readLine());
		}

		int max; // 최대 득표 수
		int maxIndex = 1; // 최대 득표 수를 받는 후보의 인덱스
		//int count = 0; // 매도 횟수
		candidate[0] = candidate[1]; // 매도 횟수 구하기 위해 원본 복사
		while (true) {
			max = 0; 
			// 최댓값 구하기 -> 변수로 따로 설정하니까 for문 못돌려서 배열변수로 변경
			for (int i = 1; i <= N; i++) {
				if (candidate[i] >= max) { // > 로만 하니까 아웃풋 틀린 거였음
					max = candidate[i];
					maxIndex = i;
				}
			}

			if (maxIndex == 1) { // 다솜이가 최대 득표자이면 매수 안해도 됨
				//System.out.println(count - 0); -> 아웃풋 틀림
				System.out.println(candidate[1] - candidate[0]);
				break; // while문 탈출
			} else { // 최대 득표자가 아니므로 매수한다
				candidate[maxIndex]--; // 최대 득표자에게서 표를 빼앗아서
				candidate[1]++; // 기호 1번 다솜이에게 준다
				//count++;
			}
		}
	}

}
