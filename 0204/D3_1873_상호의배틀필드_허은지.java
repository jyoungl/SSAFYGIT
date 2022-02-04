package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. T = 테스트케이스
 * 2. H W = 높이 H, 너비 W
 * 3. 맵
 * 4. 정수 N = 움직일 숫자
 * 5. 움직이는 글자
 */
public class D3_1873_상호의배틀필드 { 

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_1873_상호의배틀필드.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // tc 테스트 케이스
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 게임 맵 높이
			int W = Integer.parseInt(st.nextToken()); // 게임 맵 너비
			
			char[][] map = new char[H][W]; // 맵 정의
			
			for(int i = 0; i<H; i++) {
				String str = br.readLine();
				for(int j = 0; j<W; j++) {
					map[i][j] = str.charAt(j);
				}
			} // 맵 만들기
			
			int N = Integer.parseInt(br.readLine()); // 입력의 길이
			String move = br.readLine(); //입력
			
			int x = 0; //전차 위치 x 좌표
			int y = 0; //전차 위치 y 좌표
			
			for(int i=0;i<move.length();i++) {
				char c = move.charAt(i); //입력 한 글자씩 나누기
				
				for(int h=0;h<H;h++) {
					for(int w=0;w<W;w++) {
						if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
							x = h;
							y = w;
						}
					}
				} //전차 위치 구하기
				
				switch (c) {
				//위, 아래, 왼쪽, 오른쪽 이동
				case 'U':
					map[x][y] = '^'; //위를 바라보게 바꿈
					if(x-1>=0 && map[x-1][y] == '.') { //평지라면
						map[x][y] ='.'; //이동
						map[x-1][y] = '^'; //위를 봄
					}
					break;
				case 'D': 
					map[x][y] = 'v';
					if(x+1<H && map[x+1][y] == '.') {
						map[x][y] = '.';
						map[x+1][y] = 'v';
					}
					break;
				case 'L':
					map[x][y] = '<';
					if(y-1>=0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						map[x][y-1] = '<';
					}
					break;
				case 'R':
					map[x][y] = '>';
					if(y+1<W && map[x][y+1] == '.') {
						map[x][y] = '.';
						map[x][y+1] = '>';
					}
					break;
				//포탄 발사(위, 아래, 왼쪽, 오른쪽)
				case 'S':
					if(map[x][y] =='^') { //위일 때
						for(int r = x;r>=0;r--) {
							if(map[r][y] =='#') //강철이라면 멈춤
								break;
							if(map[r][y] =='*') { //벽돌이라면
								map[r][y] = '.'; //평지 만듦
								break;
							}
						}
					}
					else if(map[x][y] =='v') {
						for(int r=x;r<H;r++) {
							if(map[r][y] =='#')
								break;
							if(map[r][y] =='*') {
								map[r][y] = '.';
								break;
							}
						}
					}
					else if(map[x][y] =='<') {
						for(int c2 =y;c2>=0;c2--) {
							if(map[x][c2] =='#')
								break;
							if(map[x][c2] =='*') {
								map[x][c2] = '.';
								break;
							}
						}
					}
					else if(map[x][y] =='>') {
						for(int c2 = y;c2<W;c2++) {
							if(map[x][c2] =='#')
								break;
							if(map[x][c2]=='*') {
								map[x][c2] = '.';
								break;
							}
						}
					}
					break;
					
				default:
					break;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
