package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.LinkedList;


public class BOJ_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			switch(str[0]) {
			case "push_front":
				queue.offerFirst(Integer.parseInt(str[1]));
				break;
			case "push_back":
				queue.offerLast(Integer.parseInt(str[1]));
				break;
			case "pop_front":
				Integer k = queue.pollFirst();
				if(k == null) {
					sb.append(-1).append('\n');
				}else {
					sb.append(k).append('\n');
				}
				break;
			case "pop_back":
				Integer k2 = queue.pollLast();
				if(k2 == null) {
					sb.append(-1).append('\n');
				}else {
					sb.append(k2).append('\n');
				}
				break;
			case "size":
				// 큐의 사이즈 출력
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if(queue.isEmpty()) {
					sb.append(1).append('\n');
				}else{
					sb.append(0).append('\n');
				}
				break;
			case "front":
				Integer k1 = queue.peekFirst();
				if(k1 == null) {
					sb.append(-1).append('\n');
				}else{
					sb.append(k1).append('\n');
				}
				break;
			case "back":
				Integer k11 = queue.peekLast();
				if(k11 == null) {
					sb.append(-1).append('\n');
				}else{
					sb.append(k11).append('\n');
				}
				break;
			}
		}
		System.out.print(sb);
	}
	
}
