package com.baekjoon.study07;

import java.util.*;
import java.io.*;

public class queue_2164_카드2 {

	static int N;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		queue = new LinkedList<>();
		
		// 큐에 숫자 넣기
		for (int i = 1; i <= N; i++)
			queue.add(i); // (front) 1 2 3 4 5 ··· N

		// 마지막 한 장이 남을 때까지
		while (queue.size() > 1) {
			queue.poll(); // 맨 앞 요소 삭제
			queue.offer(queue.poll()); // 앞쪽 요소(맨 앞 요소 바로 뒷 요소)를 뒤에 삽입
		}
		System.out.println(queue.poll());

	}

}
