package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_1021_회전하는큐 {
	
	static Deque<Integer> deq = new LinkedList<>();
	static Deque<Integer> deq2 = new LinkedList<>();
	// 일단 구현
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str=  in.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int[] arr = new int[M];
		

		String[] str2 = in.readLine().split(" ");
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}


		for(int i=1;i<=N;i++) {
			deq.offer(i);
			deq2.offer(i);
		}
		int cntsum = 0;
		for(int i=0;i<M;i++) {
			int cnt1 = forwardSearch(arr[i]);
			int cnt2 = backwardSearch(arr[i]);
			cntsum = cntsum + Math.min(cnt1, cnt2);
			deq.poll();
			deq2.poll();
		}
		System.out.println(cntsum);
	}

	// <<<< 이쪽 방향으로 미는 것을 forward로 하자.
	public static int forwardSearch(int num) {
		int cnt = 0;
		while(deq.peek() != num) {
			deq.offerLast(deq.pollFirst());
			cnt++;
		}
		return cnt;
	}
	// >>> 이쪽 방향으로 미는 것을 backward로 하자.
	public static int backwardSearch(int num) {
		int cnt = 0;
		while(deq2.peek() != num) {
			deq2.offerFirst(deq2.pollLast());
			cnt++;
		}
		return cnt;
	}
}
