package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 아홉 개 줄에 자연수가 주어짐
 * 출력
 * 1. 일곱 난쟁이가 쓴 모자에 쓰여 있는 수 한 줄에 하나씩 출력
 * 
 * >> 전체를 더한 뒤 둘 더해서 빼기
 * >> 조합으로 풀어보기
 */
public class BJ_3040_백설공주와일곱난쟁이 {
	
	static int[] input;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		result = new int[7];
		
		for(int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		hat(0, 0);
	}

	private static void hat(int cnt, int start) {
		if(cnt==7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += result[i];
			}
			if(sum==100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
			}
			return;
		}
		for(int i = start; i<9; i++) {
			result[cnt] = input[i];
			hat(cnt+1, i+1);
		}
	}
}
