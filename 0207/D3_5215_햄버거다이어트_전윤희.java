package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거다이어트 {

	static int T, N, L, satisfactionMax; // 테스트케이스, 재료수, 제한칼로리, 만족도점수(result)
	static StringTokenizer st;
	static int[] satisfaction;
	static int[] calorie;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_5215_햄버거다이어트.txt"));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			satisfaction = new int[N]; // 각 재료에 대한 만족도
			calorie = new int[N]; // 각 재료에 대한 칼로리

			// 배열 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				satisfaction[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}

			satisfactionMax = 0;
			function(0, 0, 0);

			System.out.println("#" + tc + " " + satisfactionMax);
		}

	}

	// 재귀
	static void function(int cnt, int s, int cal) { //누적대상 인덱스, 만족도 점수합, 칼로리 합
		// 기저파트
		if (cal > L) { // 제한 칼로리 초과한 경우
			return;
		}
		if (cnt == N) {
			satisfactionMax = Math.max(satisfactionMax, s);
			return;
		}

		// 유도파트
		function(cnt + 1, s + satisfaction[cnt], cal + calorie[cnt]); // 재료 사용
		function(cnt + 1, s, cal); // 재료 사용 X
	}

}
