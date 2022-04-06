package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 구글링) 스택에 1에서 T까지의 수를 넣고(push) (오름차순 순서. 그러니까 1, 2, 3, 4, ···, T) pop을 통하여 숫자를
 * 빼내면서 input과 동일하게 수열을 뽑아낸다
 * 
 * input : [4, 3, 6, 8, 7, 5, 2, 1] 1부터 n까지에 수에 대해 차례로 [push, push, push, push,
 * pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop] 연산을 수행하면 수열
 * [4, 3, 6, 8, 7, 5, 2, 1]을 얻을 수 있다.
 * 
 * 이해를 못했던 이유) 스택 안에 input 숫자를 오름차순으로 정렬하면서 넣는게 아님!
 */

public class stack_1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 1부터 T까지 수를 늘어놓음

		Stack<Integer> stack = new Stack<>();

		int start = 1;
		for (int t = 0; t < T; t++) {
			boolean check = false;
			int number = Integer.parseInt(br.readLine());
			while (start <= number) {// number값이 start값보다 크거나 같다면
				sb.append("+\n");
				stack.push(start++);
				// start값부터 number값 까지 stack에 push 해주고
				check = true;
			}
			while (!stack.isEmpty() && stack.peek() >= number) {
				sb.append("-\n");
				stack.pop();
				check = true;
			}
			if (!check) {
				sb = new StringBuilder("NO");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();

	}

}
