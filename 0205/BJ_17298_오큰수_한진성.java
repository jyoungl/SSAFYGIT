package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BJ_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		String[] str = in.readLine().split(" ");
		Stack<Integer> stack = new Stack<>();
		// Map으로 하니 중복일 때 덮어씌워버리는 문제 발생
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int[] B = new int[N];
		// 스택으로 풀어보기
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(str[i]);
			int cnt = i;
			A[i] = K;
			if (i == 0) {
				stack.push(K);
				list.add(i);
				continue;
			}
			while (true) {
				if (!stack.empty() && stack.peek() < K) {
					if(B[--cnt] != 0) {
						continue;
					}else {
						B[cnt] = K;
					}

					stack.pop();
				} else {

					break;
				}
			}
			stack.push(K);
		}

// 스택 안쓰고 풀어보기 - 시간초과		
//		go:for(int i=0;i<N;i++) {
//			for(int j=i;j<N;j++) {
//				if(A[i] < A[j]) {
//					arr.add(A[j]);
//					continue go;
//				}
//			}
//			arr.add(-1);
//		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (B[i] == 0) {
				B[i] = -1;
			}
			sb.append(B[i]).append(" ");
		}
		System.out.print(sb);

	}

}
