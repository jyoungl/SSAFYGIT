package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			stack.push(i);
			sb.append("+\n");
			while(true) {
				if(!stack.empty()&&arr[cnt] == stack.peek()) {
					sb.append("-\n");
					stack.pop();
					cnt++;
				}else {
					break;
				}
			}
		}
		if(stack.empty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		

	}

}
