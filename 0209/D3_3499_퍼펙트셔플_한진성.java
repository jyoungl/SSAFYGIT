package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {

	// 2번쨰 방법 스택으로 자르고, 스택에 번갈아가면서 넣은 뒤에 덱으로 앞에서부터 넣기
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_3499.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			Deque<String> que = new LinkedList<>();
			Stack<String> stack = new Stack<>();
			Stack<String> stack2 = new Stack<>();

			for (int i = 0; i < N; i++) {
				que.add(st.nextToken());
			}

			// 절반 스택1에 꺼내기
			for (int i = 0; i < N / 2; i++) {
				stack.push(que.removeLast());
			}
			// 번갈아가면서 스택2에 집어넣기
			for (int i = 0; i < N / 2; i++) {
				stack2.push(que.pollFirst());
				stack2.push(stack.pop());
			}
			// 홀수일 때
			if (que.size() % 2 == 1) {
				// 홀수일때는 원래 들어있던 값이 1개 더 많기 때문에 한 번 더 집어넣어주기
				stack2.push(que.pollFirst());
			} 
			// 스택2에 있는 값 차례대로 덱에 앞에서부터 집어넣기
			for (int i = 0; i < N; i++) {
				que.offerFirst(stack2.pop());
			}
		
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(que.remove()).append(" ");
			}

			System.out.printf("#%d %s\n", tc, sb);

		}

	}

	// 1번 방법 : 스택으로 꺼내서 저장하고, 값은 LinkedList로 중간에 삽입한다.
	public static void main1(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_3499.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			LinkedList<String> que = new LinkedList<>();
			Stack<String> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				que.add(st.nextToken());
			}

			// 이 때는 짝수 홀수 구분 안해도 잘 돌아간다.

			// 절반 꺼내기
			for (int i = 0; i < N / 2; i++) {
				stack.push(que.removeLast());
			}
			// LinkedList에 index 통해서 삽입
			for (int i = 0; i < N; i++) {
				if (i % 2 == 1) {
					que.add(i, stack.pop());
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(que.remove()).append(" ");
			}

			System.out.printf("#%d %s\n", tc, sb);

		}

	}

}
