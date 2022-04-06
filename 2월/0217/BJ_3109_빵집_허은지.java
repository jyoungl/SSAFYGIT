package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. R C 크기
 * 2. 빵집 근처의 모습 .는 빈칸 x는 건물
 * 
 * 출력
 * 원웅이가 놓을 수 있는 파이프라인의 최대 개수
 * 
 * >> 오른쪽, 오른쪽 대각선 위, 아래로 놓을 수 있음 경로는 겹치거나 접할 수 없음
 */
public class BJ_3109_빵집_허은지 {
	static int R, C, ans;
	static char[][] arr;
	static int[] dx = {-1, 0, 1};
	static boolean check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C+1];
		ans = 0;
		
		for(int i = 0; i < R; i++) {
			String r = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = r.charAt(j);
			}
		}
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < R; i++) {
			check = false;
			pipe(i,0);
		}
		
		System.out.println(ans);

	}
	private static void pipe(int x,int y) {
		if(y==C-1) {
			check = true;
			ans++;
			return;
		}
		for(int i = 0; i<3; i++) {
			int row = x+dx[i];
			int col = y+1;
			if(row>=0 && row<R && arr[row][col] == '.') {
				if(check) return;
				arr[row][col] = 'x';
				pipe(row, col);
			}

		}
		
	}

}
