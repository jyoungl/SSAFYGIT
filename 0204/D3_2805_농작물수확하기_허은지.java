package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫줄 T = 테스트 케이스
 * 다음줄 N = 농장 크기
 * 출력 = "#" + tc + " " + 수익
 * 
 * 별찍기 해서 출력하기!!
 * ㄴ 2차 배열에 넣기
 * ㄴ 나머지로 하기
 */
public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_2805_농작물수확하기.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				String num = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = num.charAt(j) -'0';
				}
			} // 배열 만들기
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(farm[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int i = 0; i<N/2; i++) {
				for(int j = N/2-i; j<=N/2+i; j++) { // 별찍기 하면 안돼서 다시 계산함
					sum += farm[i][j];
				}
			}
			
			for(int i = N/2; i>=0; i--) {
				for(int j = N/2-i; j<=N/2+i; j++) {
					sum += farm[N-i-1][j];
				}
			}
			System.out.println("#" + (tc+1) + " " + sum);
		} // tc
	} // main
} // class


			// 별 만들기
//		int N = 7;
//			for(int i = 0; i<=N/2; i++) {
//				for(int j = 0; j<N/2-i; j++) {
//					//System.out.println(j);
//					System.out.print(" ");
//				}
//				for(int j = 0; j<i*2+1; j++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
//			
//			for(int i = 0; i<N/2; i++) {
//				for(int j = 0; j<i+1; j++) {
//					//System.out.println(j);
//					System.out.print(" ");
//				}
//				for(int j = 0; j<N-(i+1)*2; j++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
			

