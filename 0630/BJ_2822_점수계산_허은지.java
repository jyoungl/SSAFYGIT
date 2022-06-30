package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_2822_점수계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] score = new int[151];
		
		for (int i = 1; i <= 8; i++) {
			int num = Integer.parseInt(br.readLine());
			
			score[num] = i;
		}
		
		int cnt = 5;
		int total = 0;
		
		List<Integer> num = new ArrayList<>();
		
		for (int i = 150; i > 0; i--) {
			if(score[i] != 0) {
				total += i;
				cnt--;
				num.add(score[i]);
			}
			if(cnt==0) break;
		}
		
		Collections.sort(num);		
		for (int i = 0; i < 5; i++) {
			sb.append(num.get(i) + " ");
		}
		
		System.out.println(total);
		System.out.println(sb);

	}

}
