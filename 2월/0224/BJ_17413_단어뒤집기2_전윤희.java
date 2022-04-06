package com.im.baekjoon;

import java.io.*;
import java.util.*;

public class BJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();

		String s = br.readLine();
		boolean flag = false; // true:차례대로, false:반대로

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				// <를 만나면 여태껏 저장해둔 문자열 거꾸로 출력 : 이 while문 필수임(왜냐면 처음시작에 꺽쇠면 상관없지만 중간에 들어갔을 땐 안쓰면 망함)
				while (!stack.isEmpty()) { // 스택이 차있으면 여태 저장한 문자열 다 출력
					System.out.print(stack.pop());
				}
				flag = true;
				System.out.print(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				flag = false; // 초기화
				System.out.print(s.charAt(i));
			} else if (flag) { // flag가 true일때 차례대로 출력
				System.out.print(s.charAt(i));
			} else if (!flag) { // flag가 false일때, 글자 저장
				if (s.charAt(i) != ' ') { // 공백나오기 전까지 글자 저장하다가
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ' ') {
					while (!stack.isEmpty()) { // 공백 다음으로 가기전에 스택에 저장된 글자 모두 출력
						System.out.print(stack.pop());
					}
					System.out.print(s.charAt(i)); // 띄어쓰기 해주기
				}

			}

		}

		// 마지막 떨거지 처리
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}

}