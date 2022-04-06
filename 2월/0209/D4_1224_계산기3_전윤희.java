package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_1224_계산기3 {
// 계산기2 응용 (새로운 방식으로 풀어보려다가 대가리 깨질 것 같아서 그냥 계산기2에 코드 몇 줄 추가함)
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new FileInputStream("input_D4_1224_계산기3.txt"));
		// Scanner in = new Scanner(System.in);

		/**
		 * 원본 3+(4+5)*6+7
		 * 
		 * 후위 표기식 만들기 
		 * ((3+((4+5)*6))+7) 
		 * 45+ 
		 * 45+6* 
		 * 345+6*+ 
		 * 345+6*+7+
		 * 
		 * 최종 후위 표기식 345+6*+7+
		 */

		// 후위 표기식 만들기
		for (int tc = 1; tc <= 10; tc++) {
			int length = Integer.parseInt(in.nextLine());

			Stack<Character> stack = new Stack<>();
			String originalLine = in.nextLine(); // 원본 문자열
			String postfix = ""; // 후위 표기식 문자열

			for (int i = 0; i < originalLine.length(); i++) {
				// 숫자인 경우 stack에 push
				if (originalLine.charAt(i) != '+' && originalLine.charAt(i) != '*' && originalLine.charAt(i) != '(' && originalLine.charAt(i) != ')') {
					postfix = postfix + originalLine.charAt(i);
				}
				// +, *, (, ) 인 경우
				else {
					if (originalLine.charAt(i) == '*') { // 곱셈인 경우
						stack.push(originalLine.charAt(i));
					} else if (originalLine.charAt(i) == '+') { // 덧셈인 경우
						do {
							if (stack.isEmpty() || stack.peek() == '(')
								break; 
							postfix = postfix + stack.pop();
						} while (!stack.isEmpty() && stack.peek() == '*'); // 덧셈인 경우, 곱셈기호가 더 우선순위가 높으므로 한 번 빼고 푸시
						stack.push(originalLine.charAt(i));
					} else if (originalLine.charAt(i) == '(') { // 열린괄호인 경우
						stack.push(originalLine.charAt(i));
						continue;
					} else if (originalLine.charAt(i) == ')') { // 닫힌괄호인 경우
						while (true) {
							if (stack.peek() == '(') {
								stack.pop();
								break;
							}
							postfix = postfix + stack.pop();
						}
						continue;
					}
				}

			}

			while (!stack.isEmpty()) { // 나머지 연산자
				postfix = postfix + stack.pop();
			}

			// 후위 연산 시작 (유튜브라이브 참고)
			Stack<Integer> calc = new Stack<Integer>();

			for (int i = 0; i < postfix.length(); i++) {
				if (postfix.charAt(i) != '+' && postfix.charAt(i) != '*') {// 유튜브 라이브 강의에서 들은대로, operand인 경우 push
					calc.push(postfix.charAt(i) - '0');
				} else { // 연산자(operator)가 나오면 연산자와 가장 가까운 두개를 빼서 계산후 push
					int operand1 = calc.pop();
					int operand2 = calc.pop();
					char operator = postfix.charAt(i);

					switch (operator) {
					case '*':
						int multi = operand1 * operand2;
						calc.push(multi);
						break;
					case '+':
						int plus = operand1 + operand2;
						calc.push(plus);
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + calc.peek());
		}
	}
}