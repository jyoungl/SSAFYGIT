package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D4_1218_괄호짝짓기.txt"));

		int length; // 문자열 길이
		String s; // 문자열

		Stack<Character> stack = new Stack<>();

		for (int tc = 1; tc <= 10; tc++) {
			length = Integer.parseInt(br.readLine());
			s = br.readLine();
			boolean pair = true;
			
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);

				// 열린 괄호 앞부분이 기준
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.push(c);
				} else if (c == ')') { // 비어있거나 미스매치
					if (stack.isEmpty() || stack.peek() == '{' || stack.peek() == '[' || stack.peek() == '<') {
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '(') { // 짝이 맞으면 들어간 열린괄호 앞부분 pop
						stack.pop();
					}
				} else if (c == '}') { // 비어있거나 미스매치
					if (stack.isEmpty() || stack.peek() == '(' || stack.peek() == '[' || stack.peek() == '<') {
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '{') { // 짝이 맞으면 들어간 열린괄호 앞부분 pop
						stack.pop();
					}
				} else if (c == ']') { // 비어있거나 미스매치
					if (stack.isEmpty() || stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '<') {
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '[') { // 짝이 맞으면 들어간 열린괄호 앞부분 pop
						stack.pop();
					}
				} else if (c == '>') { // 비어있거나 미스매치
					if (stack.isEmpty() || stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '[') {
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '<') { // 짝이 맞으면 들어간 열린괄호 앞부분 pop
						stack.pop();
					}
				}
			}

			if (stack.isEmpty() || pair == true) {
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
		}

	}
}
