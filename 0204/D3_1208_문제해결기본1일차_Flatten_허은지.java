package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 테스트 케이스(tc) = 10번
 * 첫 줄 N = 덤프 횟수
 * 가로 길이 box[100]
 * 출력 = "# " + tc + 높이 차
 * 
 * min과 max를 이용해 max를 min으로 하나씩 옮기기
 * min이 올라가면 다른 숫자들과 비교해 min과 max 바꿔가면서 덤프
 * 
 * >> 정렬해서 쓰는 게 더 편할것 같아서 바꿈
 */
public class D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_1208_Flatten.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) { //테스트 케이스 10회
			int N = Integer.parseInt(br.readLine()); // 덤프 횟수 N
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100]; // 숫자 넣을 box 가로 길이 100
			int result = 0; // 결과값
			
			for(int i = 0; i < 100; i++) {	
				box[i] = Integer.parseInt(st.nextToken());
			} // box에 숫자 넣기	
			
			Arrays.sort(box); // box 순서대로 정렬(작은 것부터 큰 순서)
			
			for(int i = 0; i < N; i++) {
				box[99]--; // 가장 높은 상자에서 하나를 빼서
				box[0]++; // 가장 낮은 상자에 쌓음
				if(box[0] > box[1]) { // 제일 낮은 상자가 그 다음 상자보다 높아지면
					Arrays.sort(box); // 재정렬
					continue;
				}
				if(box[99] < box[98]) { // 제일 높은 상자가 그 다음 상자보다 낮아지면
					Arrays.sort(box); // 재정렬
					continue;
				}
			}

			result = box[99]-box[0]; // 높이 차이
			System.out.println("#" + tc + " " + result);
			
		} // tc for문

	} // main

} // class
