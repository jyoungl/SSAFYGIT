package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_1225.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int tc = 1; tc<=T;tc++) {
			Queue<Integer> queue = new LinkedList<>();
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			go:while(true) {
				// 1사이클
				for(int i=1;i<=5;i++) {
					int num = queue.poll()-i;
					if(num <= 0) {
						queue.offer(0);
						break go;
					}else {
						queue.offer(num);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i=0;i<8;i++) {
				sb.append(" ").append(queue.poll());
			}
			System.out.println(sb);
		}
	}
}
