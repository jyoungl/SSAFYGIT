package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력 N 배달해야 하는 설탕의 무게
 * 출력 봉지의 최소 개수, N킬로그램을 만들 수 없다면 -1
 * 
 * >> 3킬로그램과 5킬로그램으로 N킬로그램 만들기
 * >> N을 5로 나눈 뒤 나머지를 3으로 나눠 0으로 맞아떨어지면 출력
 * >> 아니라면 5를 한 개씩 줄인 뒤 3으로 나눠 0으로 맞아떨어지면 출력
 * >> 3으로만 이루어져도 안 되면 -1 출력
 */
public class BJ_2839_설탕배달_허은지 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		sugar(0);

	}

	private static void sugar(int i) {
		int five = 0;
		int three = 0;
		
		five = N/5 - i;
		three = (N-(five*5))/3;
		
		if(five == 0 && (N-(five*5))%3 != 0) {
			System.out.println("-1");
			return;
		}
		
		if((N-(five*5))%3 == 0) {
			System.out.println(five+three);
			return;
		} else {
			sugar(i+1);
		}
	}
}
