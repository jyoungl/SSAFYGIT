package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] nan;
	static int[] arr;
	static boolean check = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];

		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		nan = new int[7];
		Arrays.sort(arr);
		
		combination(0,0);
		
	}

	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
//			System.out.println(Arrays.toString(nan));
			for(int i=0;i<7;i++) {
				sum += nan[i];
			}
			if(sum == 100 && !check) {
				check = true;
				Arrays.sort(nan);
				for(int i=0;i<7;i++) {
					System.out.println(nan[i]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			nan[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
		
		
	}
	
}
