package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//pop, push, isEmpty, clear, peek

public class stack_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>(); // 자바 스택 클래스 사용
		int T = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				stack.pop(); // pop() 메서드 : 값 추출
			} else {
				stack.push(n); // push() 메서드 : 값 삽입
			}
		}

		while (!stack.isEmpty()) {// 스택이 비어있지 않다면
			sum = sum + stack.pop(); //.pop()이 스택의 맨 위에서 개체를 제거하고 반환
		}

		System.out.println(sum);
	}

}

