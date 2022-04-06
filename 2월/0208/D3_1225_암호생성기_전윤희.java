package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D3_1225_암호생성기 {

	static Queue<Integer> queue;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_1225_암호생성기.txt"));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테스트케이스를 이미 선언했으므로 문제 번호를 담는 변수는 따로 선언하지 않는다
			st = new StringTokenizer(br.readLine(), " ");

			queue = new LinkedList<>();
			sb.append("#" + tc + " ");

			// 큐 초기화
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			// System.out.println(queue);
			// [9550, 9556, 9550, 9553, 9558, 9551, 9551, 9551]

			int count = 1; // 1~5까지 로테이션

			while (true) {
				int front = queue.poll(); // 앞자리 지워주고
				if (front - count <= 0) { // 0보다 작아지거나 0일 때
					queue.offer(0);
					break; // 암호 도출
				} else {
					queue.offer(front - count); // 뒷자리 갈 때 -count;
				}

				if (count + 1 > 5) {
					count = 1;
				} else {
					count++; 
				}
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " "); // front에서 하나씩 빼자
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}
}