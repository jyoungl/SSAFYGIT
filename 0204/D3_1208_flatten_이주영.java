package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class D3_1208_flatten {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//10개의 test case
		for(int tc=1;tc<=10;tc++) {
			int dump = in.nextInt();
			int[] box = new int[100];
			int max = 0;
			int min = 101;
			
			//상자 높이 입력 받음
			for(int i=0;i<100;i++) {
				box[i] = in.nextInt();
			}
			
			Arrays.sort(box);
			
			//덤프 진행
			for(int i=0;i<dump;i++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}

			int res = box[99] - box[0];
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}

}
