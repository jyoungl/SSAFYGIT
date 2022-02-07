package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		Deque<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {		
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		int cnt2 = 0;
		sb.append("<");
		while(cnt2 <= N-1){
			if(cnt == K-1) {
				if(cnt2 == N-1) {
					sb.append(queue.poll());
				}else {
					sb.append(queue.poll()).append(", ");
				}
				cnt = 0;
				cnt2++;
			}else {
				int num = queue.poll();
				queue.offer(num);
				cnt++;
			}		
		}
		sb.append(">\n");
		
		System.out.print(sb);
		
		
	}

}
