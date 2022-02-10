package com.ssafy.im;

import java.util.*;
import java.io.*;

// 선형 구조
public class BJ_1158_요세푸스문제 {

	public static int N, K;
	public static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 총 사람수
		K = Integer.parseInt(st.nextToken()); // 제거해야할 순서

		queue = new LinkedList<>();
		// 큐에 숫자 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		josephus();
	}

	public static void josephus() {
		StringBuilder sb = new StringBuilder("<");

		// 큐가 마지막 한자리 수가 남을 때까지
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) { // k-1번만큼 앞쪽 요소를 뒤에 삽입 (k번째에 있는 요소를 꺼내기 위해 앞의 요소들을 제거(뒤로 보냄))
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
