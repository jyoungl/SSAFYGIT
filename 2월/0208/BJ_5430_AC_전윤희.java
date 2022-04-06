package com.baekjoon.study07;

import java.util.*;
import java.io.*;

// 대괄호 쪼개는거 구글링
public class queue_5430_AC {

	static int T; // 테스트케이스
	static String condition; // AC언어 : 예시) RDD
	static int N; // 배열의 갯수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			condition = br.readLine(); // AC 언어 읽어와서
			N = Integer.parseInt(br.readLine()); // N개의 숫자를 받을 거임

			Deque<Integer> deque = new LinkedList<>();

			// 구글링 (StringTokenizer로 접근하다가 뇌절함)
			String s = br.readLine(); // N개의 숫자 전체를 문자열로 읽어와서
			String[] s1 = s.split("[\\[\\]\\,]");

			// 배열 초기화
			for (int i = 1; i < s1.length; i++) {
				deque.add(Integer.parseInt(s1[i]));
			}

			// FrontBack 참이면 앞에서 빼고, 거짓이면 뒤에서 뺀다
			// check : 에러 체크
			boolean FrontBackCheck = true;
			boolean check = true;

			for (int i = 0; i < condition.length(); i++) {
				char c = condition.charAt(i);
				if (c == 'R') { // 뒤집기
					FrontBackCheck = !FrontBackCheck; // false 이므로 뒤에서 뺄 예정
				}
				if (c == 'D') {
					if (deque.isEmpty()) { // 배열이 비어있는데 D를 사용한 경우에는 에러가 발생 (문제 명시)
						check = false; // 후에 error 출력
						// break;
						continue;
					} else {
						if (FrontBackCheck) {
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
					}
				}

			}

			StringBuilder sb = new StringBuilder();
			if (!check) { // 비어있는 배열 D처리 할 경우
				//sb.append("error");
				System.out.print("error");
			} else {
				sb.append("\n");
				sb.append("[");
				// System.out.print("[");
				if (!deque.isEmpty()) {
					if (FrontBackCheck) { // 출력시에는 앞에서 부터 출력하는데, 방향 제대로라서 앞에서부터 출력
						while (!(deque.size() == 1)) {
							sb.append(deque.pollFirst());
							sb.append(",");
							// System.out.print(deque.pollFirst()+",");
						}
					} else { // 출력시에는 앞에서 부터 출력하는데, 방향 역방향이라서 뒤에서부터 출력
						while (!(deque.size() == 1)) {
							sb.append(deque.pollLast());
							sb.append(",");
							// System.out.print(deque.pollLast()+",");
						}

					}
					sb.append(deque.poll()); // deque.size() == 1 (따로 뺀 이유 : 마지막에는 반점 없으니까)
					// System.out.print(deque.poll());
				}
				sb.append("]");
				// System.out.println("]");
			}

			System.out.println(sb);

		}

	}

}
