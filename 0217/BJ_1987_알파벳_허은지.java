package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 세로 R 가로 C
 * 2. R개의 줄 동안 C개의 알파벳
 * 
 * 출력
 * 말이 지날 수 있는 최대의 칸 수
 * 
 * >> 상하좌우로 이동 가능
 * >> 이제까지 밟은 적 없은 알파벳이어야 함
 * >> 좌측 상단에서 시작
 * 
 * >> check[26] 배열 사용
 * >> boolean 함수 사용
 */
public class BJ_1987_알파벳_허은지 {

	static int R, C, cnt, ans;
	static boolean[] check;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		check = new boolean[26];
		ans = 0;
		cnt = 0;
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		alpabet(0, 0);
		
		System.out.println(ans);

	}
	private static void alpabet(int x, int y) {
		if(check[arr[x][y]-'A']) {
			ans = Math.max(ans, cnt);
//			System.out.println("이동한 횟수: " + cnt);
//			System.out.println("최댓값: " + ans);
			return; //이미 쓴 알파벳이라면 최댓값 구하고 리턴
		}
		
//		System.out.println("-------------------------");
//		System.out.println("현재 위치: " + arr[x][y]);
		
		check[arr[x][y]-'A'] = true; //안 썼으면 표시
		cnt++; //if 아니면 cnt++
		
		for(int i = 0; i < 4; i++) { //4방 탐색이니까 for문 네 번
//			System.out.println("i값은: " + i);
			int r = x+dx[i]; //상하좌우
			int c = y+dy[i];
			
			if(r<0 || r>=R || c<0 || c>=C) {
//				System.out.println("배열 벗어남");
				continue; //배열 벗어나면 continue
			}
			
//			System.out.println("이동할 위치: " + r + " " + c + " " + arr[r][c]);
//			System.out.println("이동한 횟수: " + cnt);
			
			alpabet(r, c); //바뀐 자리에서 다시 함수 돌리기
		}
		check[arr[x][y]-'A'] = false; //재귀 끝나면 다시 안 쓴 것으로 표시
		cnt--; //재귀 끝나고 나오면 cnt--
		
//		System.out.println("&&&&&&&&&&&&&&&&&&");		
	}

}
