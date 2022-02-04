package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D2_2001_파리퇴치.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 T

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //N*N 배열 안에서
			int M = Integer.parseInt(st.nextToken()); //M*M 배열만큼 파리 잡기
			
			int[][] arr = new int[N][N]; //배열
			int max = 0; //최댓값 구하기
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} //배열 생성
			
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					int sum = 0; //파리 개수
					for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							sum += arr[k+i][l+j];
						}
					}	
					if(sum>max) max = sum;
				}
			}
			System.out.println("#" + tc + " " + max);
		} //tc
	} // main
} // class
