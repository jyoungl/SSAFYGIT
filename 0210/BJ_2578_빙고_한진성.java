package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// 
		int[][] dir = { {0,1}, {0,-1}, {1,0},{-1,0}, {-1,-1},{1,1}, {-1,1},{1,-1}};
		
		int[][] arr = new int[5][5];
		int[][] ans = new int[5][5];
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<5;j++) {
				ans[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int bingocnt = 0;
		// 겉 반복문 2개, 빙고 부르는 반복
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				cnt++;
				
				int num = ans[i][j];
				// 안 반복문 2개, 빙고 매칭해서 0으로 바꾸는 반복
				for(int x = 0; x<5;x++) {
					for(int y = 0; y < 5; y++) {
						if(arr[x][y] == num) {
							arr[x][y] = 0;
							//대각선1
							int incnt1 = 0;
							//대각선2
							int incnt2 = 0;
							//좌우
							int incnt3 = 0;
							//상하
							int incnt4 = 0;
							// 안안 반복문, 확장 8방 탐색하기
							for(int d = 0; d<5; d++) {
								// 대각선1
								for(int n = 0; n<2;n++) {
									int dx = x + dir[n][0]*d;
									int dy = y + dir[n][1]*d;
									if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5 && arr[dx][dy] == 0) {
										incnt1++;
									}
								}
								// 대각선2
								for(int n = 2; n<4;n++) {
									int dx = x + dir[n][0]*d;
									int dy = y + dir[n][1]*d;
									if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5 && arr[dx][dy] == 0) {
										incnt2++;
									}
								}
								// 좌우
								for(int n = 4; n<6;n++) {
									int dx = x + dir[n][0]*d;
									int dy = y + dir[n][1]*d;
									if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5 && arr[dx][dy] == 0) {
										incnt3++;
									}
								}
								// 상하
								for(int n = 6; n<8;n++) {
									int dx = x + dir[n][0]*d;
									int dy = y + dir[n][1]*d;
									if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5 && arr[dx][dy] == 0) {
										incnt4++;
									}
								}
							}
							if(incnt1 == 6) {
								bingocnt++;
							}
							if(incnt2 == 6) {
								bingocnt++;
							}
							if(incnt3 == 6) {
								bingocnt++;
							}
							if(incnt4 == 6) {
								bingocnt++;
							}
							if(bingocnt >= 3) {
								
								System.out.println(cnt);
								return;
							}
						}
					}
				}
				
			}
		}
	}

}
