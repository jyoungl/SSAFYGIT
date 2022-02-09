package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_1228.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int tc =1 ;tc<=T;tc++) {

			int N = Integer.parseInt(in.readLine());
			String[] str = in.readLine().split(" ");
			Deque<Integer> deq = new ArrayDeque<>();
			for(int i=0;i<N;i++) {
				deq.offer(Integer.parseInt(str[i]));
			}
			
// 			// 테스트
//			for(int i=0;i<N;i++) {
//				System.out.print(deq.poll()+": ");
//			}
			
			int M = Integer.parseInt(in.readLine());
			
			String[] str2 = in.readLine().split("I ");
//			System.out.println(str2[7]);
			for(int i=1;i<=M;i++) {
				String[] str3 = str2[i].split(" ");
				int index = Integer.parseInt(str3[0]);
				
				int K = Integer.parseInt(str3[1]);
				Stack<Integer> stack = new Stack<>();
				for(int j=0;j<index;j++) {
					stack.push(deq.poll());
				}
				for(int j=2;j<K+2;j++) {
					stack.push(Integer.parseInt(str3[j]));
				}
				while(!stack.isEmpty()) {
					deq.offerFirst(stack.pop());
				}
			}
			StringBuilder sb =new StringBuilder();
			sb.append("#").append(tc);
			for(int i=0;i<10;i++) {
				sb.append(" ").append(deq.poll());
			}
			System.out.println(sb);
		}
	}
}
