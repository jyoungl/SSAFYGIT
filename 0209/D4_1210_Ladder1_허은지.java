package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스 10개
 * 2. 테스트 케이스 번호
 * 3. 테스트 케이스
 * 4. 2부터 시작해서 거꾸로 올라가기
 * 5. 2방 탐색(왼, 오) 하면서 올라가다가 1 발견하면 감
 * 6. 끝나면 다시 위로 올라감
 * 7. 더 올라갈 곳이 없으면 y값 반환
 * 8. 출력: "#" + T + " " + y
 */
public class D4_1210_Ladder1 {
	static int x, y, result;
	static int[][] ladder;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_1210_Ladder1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
					
			ladder = new int[100][100];

			for(int i = 0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			} //배열
			
			x = 99;
			y = 0;
			
			for(int j = 0; j<100; j++) {
				if(ladder[99][j]==2) {
					y=j;
					break;
				}
			} //도착 위치 찾기
			
			while(x!=0) { //첫줄에 도달하면 종료
				
				if(y<0 || y>99) continue; //배열을 벗어나면 continue
				if(y > 0 && ladder[x][y-1]==1) {//왼쪽에서 1 만나면 left 함수 실행
					left(y);
				} else if(y < 99 && ladder[x][y+1]==1) {//오른쪽에서 1 만나면 right 함수 실행
					right(y);
				}
				
				x = x-1; //아무것도 없으면 위로 가기
				
			}
			System.out.println("#" + T + " " + y);
		}
		
	}
	
	public static void left(int yy) {
		if(yy-1<0 || ladder[x][yy-1]==0) { //배열을 벗어나거나 0을 만나면 다시 위로 가기
			y = yy;
			return;
		} else {	
			left(yy-1); //if 만날 때까지 계속 왼쪽으로 가기
		}
	}
	
	public static void right(int yy) {
		if(yy+1>=100 || ladder[x][yy+1]==0) { //배열을 벗어나거나 0을 만나면 다시 위로 가기
			y = yy;
			return;
		} else {
			right(yy+1); //if 만날 때까지 계속 오른쪽으로 가기
		}
	}

}
