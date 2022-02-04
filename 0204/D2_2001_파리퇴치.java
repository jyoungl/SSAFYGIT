package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2001.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			String[] str = in.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String[] str2 = in.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(str2[j]);
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {			
				for(int j=0;j<N;j++) {
					if(i+M > N || j + M > N) {
						continue;
					}
					int sum = 0;
					for(int x=i;x<i+M;x++) {
						for(int y=j;y<j+M;y++) {
							sum+=arr[x][y];
						}
					}
					
					if(max < sum) {
						max = sum;
					}
				}
			}
			
			// -- 출력부
			System.out.printf("#%d %d\n",tc,max);
		}

	}

}
