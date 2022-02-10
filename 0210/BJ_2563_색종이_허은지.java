package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 색종이의 수 N
 * 2. 색종이의 위치 x, y
 * 3. 도화지의 크기 100*100
 * 4. 색종이의 크기 10*10
 * 
 * >> 배열에 담아서 1 넣고 1의 개수 출력
 */
public class B1_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x 좌표
			int y = Integer.parseInt(st.nextToken()); // y 좌표
			for(int i = x; i < x+10; i++) { //가로 10
				for(int j = y; j < y+10; j++) { //세로 10만큼
					paper[i][j] = 1; //색칠하기
				}
			}			
		}
		
		int result = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j]==1) result++; // 1이 들어 있으면 result++
			}
		}
		
		System.out.println(result);
		
	}
}
