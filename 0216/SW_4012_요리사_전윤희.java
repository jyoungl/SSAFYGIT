package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 식재료 i를 식재료 j와 같이 요리하게 되면 발생하는 시너지 Sij
 * 음식의 맛은 시너지들의 합
 * 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 
 * 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고
 * 그 최솟값을 정답으로 출력
 */

// 처음엔 i j 합과 j i 합이 달라서 순열로 접근했는데 틀림
// 식재료 선택은 조합을 이용
// 더할때 그냥 바로 i j 랑 j i 더하면 됨

public class SW_4012_요리사 {

	static int T; // 총 테스트케이스
	static int N; // 식재료 개수
	static int taste; // static int taste = Integer.MAX_VALUE; 로 선언하면 계속 아웃풋 잘못 나옴. 이유가 뭐지
	static int[][] food; // 식재료 조합 별 시너지를 저장하는 변수
	static boolean[] check; // 음식A 만들때 사용한 식재료 : T, 음식B 만들때 사용한 식재료 : F

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_모의SW역량테스트_4012_요리사.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine()); // 총 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			taste = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine()); // 식재료 개수

			food = new int[N][N]; // 식재료 모든 경우의 수를 표로 만드는 배열
			check = new boolean[N];

			// 배열 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);

			System.out.println("#" + tc + " " + taste);
		}

	}

	public static void combination(int cnt, int start) {

		// 기저조건
		if (cnt == N / 2) {
			int A = 0; // 음식A 맛
			int B = 0; // 음식B 맛
			int result = 0;

			// 테스트케이스 조합 확인용
			// System.out.println(Arrays.toString(check));

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (check[i] && check[j]) { // 음식 A에 쓰인 식재료(true)
						A = A + (food[i][j] + food[j][i]);
					} else if (!check[i] && !check[j]) { // 음식 B에 쓰인 식재료(false)
						B = B + (food[i][j] + food[j][i]);
					}
				}

			}
			result = Math.abs(A - B);
			taste = Math.min(result, taste);

			return;
		}

		// 유도파트
		for (int i = start; i < N; i++) {
			check[i] = true;
			combination(cnt + 1, i + 1);

			// output 틀렸던 이유 : check[i] = false; 로 변경 필수
			// 조합은 맞지만, 숫자 뽑는 조합이랑은 조금 다르게 생각해야함
			// start 부터 시작하기 때문에 조합은 맞지만, 숫자 조합 때처럼 true/false를 뽑는게 아니기 때문에 boolean값을 변경 해줘야함
			check[i] = false; 
		}
	}

}
