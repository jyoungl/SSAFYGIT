package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		go:while (true) {
			// (), [] 담을 스택
			Stack<Integer> stack1 = new Stack<>();

			char[] chars = in.readLine().toCharArray();
			// 종료 조건
			if (chars.length == 1 && chars[0] == '.') {
				break;
			}
			for (int i = 0; i < chars.length; i++) {
				switch (chars[i]) {
				case '(':
					stack1.push((int) chars[i]);
					break;
				case ')':
					if (!stack1.empty()&&stack1.peek() == '(') {
						stack1.pop();
					} else {
						System.out.println("no");
						continue go;
					}
					break;
				case '[':
					stack1.push((int) chars[i]);
					break;
				case ']':
					if (!stack1.empty()&&stack1.peek() == '[') {
						stack1.pop();
					} else {
						System.out.println("no");
						continue go;
					}
					break;
				}
			}
			if (stack1.empty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}

}
