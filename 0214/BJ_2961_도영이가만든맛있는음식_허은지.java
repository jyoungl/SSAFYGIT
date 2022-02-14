package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 재료의 개수 N
 * 2. 신맛 S 쓴맛 B
 * 출력
 * 1. 신맛과 쓴맛의 차이가 가장 작은 요리의 차이
 * 
 * >> 신맛은 곱하고 쓴맛은 더해야 함
 * >> 재료 모두 고른 뒤 신맛과 쓴맛 계산 >> 부분집합
 */
public class BJ_2961_도영이가만든맛있는음식 {

	static int N;
	static int[] S, B;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		cook(0);
		
		System.out.println(min);

	}//main

	//부분집합
	private static void cook(int cnt) {
		
		if(cnt==N) {
			int Smul = 1;
			int Bplus = 0;

			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					Smul *= S[i];
					Bplus += B[i];
				}
			}
			if(Smul==1 && Bplus==0) return; //재료를 하나도 사용하지 않은 건 포함하지 않음

			min = Math.min(min, Math.abs(Smul-Bplus)); //쓴맛과 신맛의 차이 중 가장 작은 값 고르기
			
			return;
		}
		
		isSelected[cnt] = true;
		cook(cnt+1);
		isSelected[cnt] = false;
		cook(cnt+1);
		
	}
}
