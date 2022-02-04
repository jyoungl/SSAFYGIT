package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class D3_1208_Flatten {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_1208_Flatten.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int T = 10; //테스트케이스
		
//		String[] s;
		int[] arr = new int[100]; // 100개의 숫자를 담을 상자(가로)
		
		int dump;

		
		
		for (int tc = 1; tc <= T; tc++) {
			dump = Integer.parseInt(br.readLine());
//			s = br.readLine().split(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
//			for (int i = 0; i < arr.length; i++) {//배열에 저장
//				arr[i] = s[i].charAt(0) - '0';
//			} 
			/**
			 * BufferedReader와 StringTokenizer
			 **/
			for (int i = 0; i < 100; i++) {//배열에 저장
				arr[i] = Integer.parseInt(st.nextToken());
			}
				
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr); //배열 정렬(오름차순)
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr); //후위연산자를 사용했으므로
			System.out.println("#"+tc+" "+(arr[99]-arr[0]));
//			sb.append("#").append(tc).append(" ").append(arr[99]-arr[0]).append("\n");
//			System.out.println(sb);
		}
	}
}
