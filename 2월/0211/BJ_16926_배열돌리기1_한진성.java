package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 회전 규칙 (index 기준) 4*4일때
*/
public class BOJ_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		//		
		int[][] dir = { {0,1},{1,0},{0,-1},{-1,0} };
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int n=0;n<R;n++) {
			// 그룹의 개수 규칙 : N, M 양쪽 배열 중 최솟값/2
			int groupNum = Math.min(N, M)/2;
			for(int d=0;d<groupNum;d++) {
				

				//
				
//				
//
//				// x, y 좌표 구분
//				int x = d, y = d;
				
//				// 시작지점의 수
//				int temp = arr[x][y];
//				for(int i=0;i<4;) {
//					int dx = x + dir[i][0];
//					int dy = y + dir[i][1];
//					
//					if(dx >= d && dx < N-d && dy >= d && dy < M-d) {
//						arr[x][y] = arr[dx][dy];
//						x = dx;
//						y = dy;
//					}else {
//						i++;
//					}
//				}
//				arr[d+1][d] = temp;
				
				
				// 원래 하려했던 방법, 
				
				int temp = arr[d][d];
				// 위쪽
				for(int i=d;i<M-d-1;i++) {
					arr[d][i] = arr[d][i+1];
				}
				
				// 오른쪽
				for(int i=d;i<N-d;i++) {
					arr[i][M-d-1] = arr[i+1][M-d-1];
				}
				
				// 아래
				for(int i=M-1-d;i>d;i--) {
					arr[N-d-1][i] = arr[N-d-1][i-1];
				}
				
				// 왼쪽
				for(int i=N-1-d;i>d;i--) {
					arr[i][d] = arr[i-1][d];
				}
				
				arr[d+1][d] = temp;
			}
		}
		
		arrprint(arr, N, M);
	}

	
	static void arrprint(int[][] arr, int N, int M) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
