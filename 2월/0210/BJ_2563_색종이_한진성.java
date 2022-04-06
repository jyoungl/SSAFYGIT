package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		//100*100 배열 생성 (0으로 초기화)
		int[][] arr = new int[101][101];
		
		// N번만큼 반복
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			//좌표값 읽어오기
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 해당 좌표에서 x+10, y+10만큼 탐색
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					// 배열의 해당 좌표의 값이 0이면, 1로 바꾼다.(0일때만 1로 바꾸기 때문에 중복제거)
					if(arr[j][k] == 0) {
						arr[j][k] = 1;
					}
				}
			}
		}
		int cnt = 0;
		
		// 배열안에 값이 1이면 카운트를 증가시켜 총 넓이 구하기
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		

	}

}
