package com.baekjoon.study07;

import java.util.*;
import java.io.*;

public class queue_18258_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// back 에 메서드 쓰려고 덱 선언
		// Deque : Double-Ended Queue. 큐의 양쪽에 데이터를 넣고 뺄 수 있는 형태의 자료구조
		Deque<Integer> deque = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				deque.offer(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				if (deque.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.poll() + "\n");
				}
				break;

			case "size":
				bw.write(deque.size() + "\n");
				break;

			case "empty":
				if (deque.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;

			case "front":
				if (deque.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.peek() + "\n"); // 스택 최상단값
				}
				break;

			case "back":
				if (deque.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.peekLast() + "\n"); // 스택 최상단값
				}
				break;
			}
		}
		bw.flush();
		bw.close();

	}

}
