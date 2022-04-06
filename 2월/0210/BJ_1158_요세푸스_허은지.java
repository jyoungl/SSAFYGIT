package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 사람 수 N K번째 사람 제거
 * 
 * >> 큐 사용해서 풀기
 */
public class S5_1158_요세푸스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		System.out.print("<");
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < K-1; j++) {
				queue.add(queue.poll());
			}
			System.out.print(queue.poll() + ", ");
		}
		System.out.println(queue.poll() + ">");
	}
}
