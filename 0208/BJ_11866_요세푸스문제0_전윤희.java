package com.baekjoon.study07;

import java.util.*;
import java.io.*;

// 구글링

public class queue_11866_요세푸스문제0 {

	public static int N, K;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();
		// 큐에 숫자 넣기
		for (int i = 1; i <= N; i++)
			queue.add(i);

		josephus();
	}

	public static void josephus() {
		StringBuilder sb = new StringBuilder("<");

		// 큐가 마지막 한자리 수가 남을 때까지
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) { // k-1번만큼 앞쪽 요소를 뒤에 삽입
				queue.add(queue.poll()); //poll은 앞, add는 뒤 (왜냐면 큐니까)
			}
			sb.append(queue.poll()); // k번째 요소를 출력
			
			if (!queue.isEmpty())
				sb.append(", ");
		}
		sb.append(">");

		System.out.println(sb);

	}

}
