package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack_4949_균형잡힌세상 { // 괄호문제응용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean pair = true;

			if (s.equals(".")) { // "."이 와야 한문장 완성
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[') {// 기준은 시작괄호들: '('과 '['
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() == '[') {// 미스매치
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '(') {// 짝이 맞으면
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() == '(') {// 미스매치
						pair = false;
					} else if (!stack.isEmpty() || stack.peek() == '[') {// 짝이 맞으면
						stack.pop();
					}
				}
			}

			if (stack.isEmpty() && pair == true) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
