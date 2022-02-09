package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D3_3499_퍼펙트셔플 {

	static int T;
	static int N;
	static String[] card;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_3499_퍼펙트셔플.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			// 배열 초기화
			card = br.readLine().split(" ");

			// 로직
			sb = new StringBuilder();
			if (N % 2 == 0) { // 카드 개수가 짝수

				// 절반으로 나눠서 각자의 큐에 집어넣은 후, 번갈아 poll()
				for (int i = 0; i < N / 2; i++) {
					queue1.offer(card[i]);
				}

				for (int j = N / 2; j < N; j++) {
					queue2.offer(card[j]);
				}

				// 교차하면서 꺼내기
				for (int k = 0; k < N / 2; k++) {
					sb.append(queue1.poll()).append(" ");
					sb.append(queue2.poll()).append(" ");
				}

			} else { // 카드 개수가 홀수

				for (int i = 0; i <= N / 2; i++) { // 오류났던 이유 : <= N으로 적어줘야 중앙값이 출력됨
					queue1.offer(card[i]);
				}

				for (int j = N / 2 + 1; j < N; j++) {
					queue2.offer(card[j]);
				}

				// 교차하면서 꺼내기
				for (int k = 0; k < N / 2; k++) {
					sb.append(queue1.poll()).append(" ");
					sb.append(queue2.poll()).append(" ");
				}
				sb.append(queue1.poll());
			}
			//sb.setLength(sb.length()-1);
			System.out.println("#" + tc + " " + sb);
		}
	}
}
