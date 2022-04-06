package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=input;tc++) {
			int[][] arr = new int[N][N];
			int sum = 0;
			
			for(int i=0;i<N;i++) {
				String[] temp = br.readLine().split("");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			int row = N - (N/2);
			for(int i=0;i<row;i++) {
				int a = 2*i+1;
				int b = N/2 - i;
				for(int j=1;j<=a;j++) {
					sum += arr[i][b];
					b++;
				}
			}
			
			int row2 = N - row;
			int row3 = row;
			int a = 2;
			for(int i=0;i<row2;i++) {
				int b = i+1;
				for(int j=N-a;j>0;j--) {
					sum += arr[row3][b];
					b++;
				}
				row3++;
				a += 2;
			}
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
		
	}

}
