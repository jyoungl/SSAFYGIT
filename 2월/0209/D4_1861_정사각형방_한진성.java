package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {

	// 현재 위치

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_1861.txt"));
		//				 우		좌	  상		하
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine());

		for(int tc=1;tc<=T;tc++) {
			
			int x = 0;
			int y = 0;
			
			int N = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[N][N];
			
			StringTokenizer st;
			
			// 2차원 배열 할당
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxCnt = 0;
			int answerarr = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++){
					int cnt = 0;
					x = i;
					y = j;
					while(true){
						int incnt = cnt;
						for(int d=0;d<4;d++) {
							int dx = x + dir[d][0];
							int dy = y + dir[d][1];
							if(dx >= 0 && dx < N && dy >= 0 && dy < N && arr[x][y]+1 == arr[dx][dy]) {
//								System.out.println(arr[x][y] +" : "+arr[dx][dy]);
								x = dx;
								y = dy;
								cnt++;
							}
						}
						if(cnt == incnt) {

							break;
						}
					}
					if(maxCnt < cnt) {
						maxCnt = cnt;
						answerarr = arr[i][j];
					}else if(maxCnt == cnt) {
						if(answerarr > arr[i][j]) {
							answerarr = arr[i][j];
						}
					}
				}
			}
			System.out.printf("#%d %d %d\n",tc,answerarr,++maxCnt);
			
		}
		
	}

}
