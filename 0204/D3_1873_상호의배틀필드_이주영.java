package com.ssafy.im;

import java.util.Scanner;

public class D3_1873_상호의배틀필드 {
	static char[][] map;
	//기본값, 우/좌/하/상
	static int[][] dir = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int tc=1; tc<=input; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			map = new char[H][W];
			
			int x = 0;
			int y = 0;
			int d = 0; // 우좌하상
			
			for(int i=0; i<H; i++) {
				String st = sc.next();
				for(int j=0; j<W; j++) {
					map[i][j] = st.charAt(j);
					
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						if(map[i][j] == '^') d = 4;
						else if(map[i][j] == 'v') d = 3;
						else if(map[i][j] == '<') d = 2;
						else if(map[i][j] == '>') d = 1;
						
						x = i;
						y = j;
					}
				}
			}
			
			int N = sc.nextInt();
			String str = sc.next();
			
			for(int i=0; i<N; i++) {
				char cur = str.charAt(i);
				int nx, ny;
				
				if(cur == 'U' || cur == 'D' || cur == 'L' || cur =='R') {
					switch(cur) {
					case 'U':
						map[x][y] = '^';
						d = 4;
						break;
					case 'D':
						map[x][y] = 'v';
						d = 3;
						break;
					case 'R':
						map[x][y] = '>';
						d = 1;
						break;
					case 'L':
						map[x][y] = '<';
						d = 2;
						break;
					}

					nx = x + dir[d][0];
					ny = y + dir[d][1];
					
					if(x>=0 && x<H && y>=0 && y<W) {
						if(map[nx][ny] == '.') {
							map[nx][ny] = map[x][y];
							map[x][y] = '.';
							x = nx; y = ny;
						}
					}
				} else if(cur == 'S') {
					// 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
					nx = x;
					ny = y;
					
					while(true) {
						nx += dir[d][0];
						ny += dir[d][1];
						if(!(x>=0 && x<H && y>=0 && y<W) || map[nx][ny] == '#') break;
						else if(map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;
						}
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}