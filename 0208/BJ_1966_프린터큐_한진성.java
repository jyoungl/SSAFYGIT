package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			String[] str = in.readLine().split(" ");
			Deque<int[]> queue = new LinkedList<>();
			int N = Integer.parseInt(str[0]);
			
			int M = Integer.parseInt(str[1]);
			Integer[] arr = new Integer[N];
			String[] str2 = in.readLine().split(" ");
			for(int i=0;i<N;i++) {
				// i는 처음위치, 뒤에는 넣은 값이 들어간다.
				queue.offer(new int[] {i,Integer.parseInt(str2[i])});
				arr[i] = Integer.parseInt(str2[i]);
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
//			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			while(true) {
				// 현재 큐의 가장 앞의 값이 원래 값의 최댓값보다 작으면 큐를 돌린다.
				if(queue.peek()[1] < arr[cnt]) {
					int[] num = queue.poll();
					queue.offer(num);
				}else {
					if(queue.peek()[0] == M) {
						System.out.println(++cnt);
						break;
					}
					queue.poll();
					cnt++;

				}
			}
		}
	}
	
	
	
	// 날로 먹으려다가 실패. 정직하게 구현해보자.
	public static void main1(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 우선순위 큐 선언, Collections.reverseOrder은 내림차순 정렬을 한다는 뜻
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T;tc++) {
			String[] str = in.readLine().split(" ");
			
			int N = Integer.parseInt(str[0]);
			
			int M = Integer.parseInt(str[1]);
			
			String[] str2 = in.readLine().split(" ");
			int[] check = new int[N]; 
			for(int i=0;i<N;i++) {
				queue.offer(Integer.parseInt(str2[i]));
				check[i] = i+1;
			}
			int answer = 0;
			for(int i=0;i<N;i++) {
				if(queue.poll() == M) {
					answer = i;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
