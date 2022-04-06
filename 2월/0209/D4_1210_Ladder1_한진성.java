package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1210_Ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_1210.txt"));
		
		//				 우		좌	   상 
		int[][] dir = {{0,1},{0,-1},{-1,0}};

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		go:for(int tc=1;tc<=10;tc++) {
			// tc 번호 날리기
			in.readLine();
			int N = 100;
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String[] str = in.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int x;
			int y;
			int ans = 0;
			for(int i=0;i<N;i++) {
				// 시작지점 2 찾기
				if(arr[N-1][i] == 2) {
					x = N-1;
					y = i;
					while(true) {
						for(int d=0;d<3;d++) {
							int dx = x + dir[d][0];
							int dy = y + dir[d][1];
							if(dx > 0 && dy < N && dy >= 0 && arr[dx][dy] == 1) {
								x = dx;
								y = dy;
								arr[x][y] = -1;
								break;
							}else if(dx == 0) {
								ans = y;
								System.out.printf("#%d %d\n",tc ,ans);
								continue go;
							}
						}
					}
				}
			}
			
			
		}
	}

}
