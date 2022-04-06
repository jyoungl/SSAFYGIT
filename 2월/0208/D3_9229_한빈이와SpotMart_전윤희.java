package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;

public class D3_9229_한빈이와SpotMart {
// 조합 (nCr인데, N = n, r = 2)
	static int data[]; // 각각의 과자 무게 저장 배열
	static int weightSum;
	static int N; // 과자 봉지 개수
	static int M; // 들 수 있는 과자 봉지 최대 무게

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_9229_한빈이와SpotMart.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			data = new int[N];

			st = new StringTokenizer(br.readLine());
			// 배열 저장
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			weightSum = 0;
			combination(0, 0, 0);

			if (weightSum == 0) { // 과자를 들고갈 방법이 없는 경우
				weightSum = -1;
			}

			System.out.println("#" + tc + " " + weightSum);
		}
	}

	// 재귀
	static void combination(int idx, int current, int count) {
		// 기저파트
		if (current > M)
			return;
		if (count == 2) { // 2개 최대
			if (weightSum < current) {
				weightSum = current;
			}
			return;
		}
		if (idx == N)
			return;

		// 유도파트
		combination(idx + 1, current + data[idx], count + 1);
		combination(idx + 1, current, count);
	}
}
