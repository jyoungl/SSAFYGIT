package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 배열의 크기 N M 수행해야 하는 회전의 수 R(한칸씩)
 * 2. N개의 줄에 배열 A의 원소
 * 3. 시계 반대방향으로 회전(안쪽도 회전)
 */

public class S2_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // arr 만들기
		
		for(int rc=0; rc<R; rc++) { //회전 횟수만큼 반복	
			
			int count = Math.min(N, M) / 2; //라인이 가장 긴 변/2 - 1만큼 돌아감
			
			for(int i=0; i<count; i++) {
				int num = arr[i][i];
				
				for(int j=i+1; j<M-i; j++) // 위쪽 줄 왼쪽으로
					arr[i][j-1] = arr[i][j];
				
				for(int j=i+1; j<N-i; j++) // 오른쪽 줄 위로
					arr[j-1][M-1-i] = arr[j][M-1-i];
				
				for(int j=M-2-i; j>=i; j--) // 아래 줄 오른쪽으로
					arr[N-1-i][j+1] = arr[N-1-i][j];
				 
				for(int j=N-2-i; j>=i; j--) // 왼쪽 줄 아래로
					arr[j+1][i] = arr[j][i];
				
				arr[i+1][i] = num;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
