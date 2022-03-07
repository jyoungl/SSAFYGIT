package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_1003_피보나치함수_전윤희 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0]=1;
		zero[1]=0;
		one[0]=0;
		one[1]=1;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 0,1,1 ... :N개

			for (int i = 2; i <= N; i++) {
				zero[i] = zero[i-1]+zero[i-2];
				one[i] = one[i-1]+one[i-2];
				
			}
			sb.append(zero[N]+" "+one[N]+"\n");
		}
		System.out.println(sb);
	}

}
