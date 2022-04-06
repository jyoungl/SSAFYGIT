package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(in.readLine());
		Deque<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			int num = queue.poll();
			queue.offer(num);
		}
		
		System.out.println(queue.poll());
	}

}
