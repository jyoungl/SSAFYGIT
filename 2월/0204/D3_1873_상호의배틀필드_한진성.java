package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IM_1873_상호의배틀필드 {
	/*
	 * 		문자 의미
	 *		.	평지(전차가 들어갈 수 있다.)
	 *		*	벽돌로 만들어진 벽
	 *		#	강철로 만들어진 벽
	 *		-	물(전차는 들어갈 수 없다.)
	 *		^	위쪽을 바라보는 전차(아래는 평지이다.)
	 *		v	아래쪽을 바라보는 전차(아래는 평지이다.)
	 *		<	왼쪽을 바라보는 전차(아래는 평지이다.)
	 *		>	오른쪽을 바라보는 전차(아래는 평지이다.)
	 *	
	 *
	 * 		 문자	동작
	 *		U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	 *		D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	 *		L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	 *		R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	 *		S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	 */
	static int H;
	static int W;
	static int x=0;
	static int y=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1873.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		for(int tc = 1; tc<=T;tc++) {
			
			String[] str = in.readLine().split(" ");
			
			H = Integer.parseInt(str[0]);
		
			W = Integer.parseInt(str[1]);
			
			char[][] map = new char[H][W];
			x=0;
			y=0;
			for(int i=0;i<H;i++) {
				map[i] = in.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					if(map[i][j] == '<' || map[i][j] == '^'|| map[i][j] == 'v'|| map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(in.readLine());
			char[] action = in.readLine().toCharArray();
//			System.out.println(Arrays.toString(action));
			for(int i=0;i<N;i++) {
				int dx;
				int dy;
				switch(action[i]){
				case 'U':
					dx = x+dir[0][0];
					dy = y+dir[0][1];
					move(map,dx,dy,'^');
					break;
					
				case 'D':
					dx = x+dir[1][0];
					dy = y+dir[1][1];
					move(map,dx,dy,'v');
					break;
				case 'L':
					dx = x+dir[2][0];
					dy = y+dir[2][1];
					move(map,dx,dy,'<');
					break;
				case 'R':
					dx = x+dir[3][0];
					dy = y+dir[3][1];
					move(map,dx,dy,'>');
					break;
				case 'S':
					shoot(map,map[x][y], dir);
					break;
				}
			}
			
			//-- 출력부
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int j=0;j<H;j++) {
				for(int k=0;k<W;k++) {
					sb.append((map[j][k]));
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

	}

	public static void shoot(char[][] map, char dir, int[][] dirr) {
		int dx = 0;
		int dy = 0;
		switch(dir) {		
		case '^':
			for(int i=0;i<H;i++) {
				dx = x+dirr[0][0]*i;
				dy = y+dirr[0][1]*i;
				if(dx >= 0 && dx < H) {
					if(map[dx][dy] == '*') {
						map[dx][dy] = '.';
						break;
					}else if(map[dx][dy] == '#'){
						break;
					}
				}
			}
			break;
		case 'v':
			for(int i=0;i<H;i++) {
				dx = x+dirr[1][0]*i;
				dy = y+dirr[1][1]*i;
				if(dx >= 0 && dx < H) {
					if(map[dx][dy] == '*') {
						map[dx][dy] = '.';
						break;
					}else if(map[dx][dy] == '#'){
						break;
					}
				}
			}
			break;
		case '<':
			for(int i=0;i<W;i++) {
				dx = x+dirr[2][0]*i;
				dy = y+dirr[2][1]*i;
				if(dy >= 0 && dy < W) {
					if(map[dx][dy] == '*') {
						map[dx][dy] = '.';
						break;
					}else if(map[dx][dy] == '#'){
						break;
					}
				}
			}
			break;
		case '>':
			for(int i=0;i<W;i++) {
				dx = x+dirr[3][0]*i;
				dy = y+dirr[3][1]*i;
				if(dy >= 0 && dy < W) {
					if(map[dx][dy] == '*') {
						map[dx][dy] = '.';
						break;
					}else if(map[dx][dy] == '#'){
						break;
					}
				}
			}
			break;
		}
	}

	public static void move(char[][] map,int dx, int dy, char k) {
		if(dx >= 0 && dx < H && dy >= 0 && dy < W && map[dx][dy] == '.') {
			char temp = map[dx][dy];
			map[dx][dy] = k;
			map[x][y] = temp;
			x = dx;
			y = dy;

		}else
		{
			map[x][y] = k;
		}
	}

}
