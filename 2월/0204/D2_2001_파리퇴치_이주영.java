package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=input;tc++) {
			String[] temp = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			int[][] arr = new int[N][N];
			int max = 0;
			
			for(int i=0;i<N;i++) {
				temp = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			int sum = 0;
			//만들어지는 파리채의 맨 첫번째 칸들
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					int x = i+M;
					int y = j+M;
					//파리채 넓이
					for(int a=i;a<x;a++) {
						for(int b=j;b<y;b++) {
							sum += arr[a][b];
						}
					}
				if(max < sum) {
					max = sum;
				}
				sum = 0;
				}
			}
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.println(sb);
	}

}
