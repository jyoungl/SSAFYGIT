package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_10828_스택 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if (stack.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
				break;
				
			case "size":
				bw.write(stack.size()+"\n");
				break;
				
			case "empty":
				if (stack.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;
				
			case "top":
				if (stack.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(stack.peek() + "\n"); // 스택 최상단값
				}
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}