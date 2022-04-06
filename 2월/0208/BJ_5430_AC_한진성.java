package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();	
		go:for(int tc=1;tc<=T;tc++) {
			
			char[] command = in.readLine().toCharArray();
			
			int  N = Integer.parseInt(in.readLine());
			// split으로 하면 매우매우매우매우매우 번거롭다. 그냥 StringTokenizer 쓰자
			StringTokenizer st = new StringTokenizer(in.readLine(),"[],");
			
			Deque<Integer> deq = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				deq.offer(Integer.parseInt(st.nextToken()));
			}
			boolean reverse = false;	
			for(int i=0;i<command.length;i++) {

				switch(command[i]) {
				case 'R':
					if(reverse == false) {
						reverse = true;
					}else {
						reverse = false;
					}
					break;
				case 'D':
					if(deq.size() == 0) {
						sb.append("error").append("\n");
						continue go;
					}else if(reverse == true){
						deq.pollLast();
					}else if(reverse == false) {
						deq.pollFirst();
					}
					break;
				}
			}
			sb.append("[");
			for(int i=0,n=deq.size();i<n;i++) {
				if(reverse == true) {
					if(i == n-1) {
						sb.append(deq.pollLast());
					}else {
						sb.append(deq.pollLast()).append(',');
					}
				}else {
					if(i == n-1) {
						sb.append(deq.pollFirst());
					}else {
						sb.append(deq.pollFirst()).append(',');
					}
				}
			}
			sb.append("]").append('\n');
		}
		System.out.print(sb);
	}

}
