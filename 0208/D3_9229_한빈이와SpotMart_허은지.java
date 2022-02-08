package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 첫줄에 TC 테스트 케이스
 * 2. N 과자 봉지 개수 M 무게 합 제한
 * 3. N개의 과자 봉지 무게
 * 4. M 초과하면 -1
 * 5. "#" + tc + " " + result;
 * 
 * >> 두 봉지를 사야 함
 * >> 두 개씩 더해서 가장 큰 값 구하기
 * >> 
 */
public class D3_9229_한빈이와SpotMart {

	public static void main(String[] args) throws IOException {
		File file = new File("D3_9229_한빈이와SpotMart.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //과자 봉지 개수
			int M = Integer.parseInt(st.nextToken()); //무게 합 제한
			int[] a = new int[N];
			int weight = 0;
			int result = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			} //과자 무게 배열
			
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					weight = a[i] + a[j]; //과자 두 개 더해서
					if(weight <= M) result = Math.max(result, weight); //M보다 작으면 최댓값 구하기
				}	
			}	
			System.out.println("#" + tc + " " + result);	
		}
	}
}
