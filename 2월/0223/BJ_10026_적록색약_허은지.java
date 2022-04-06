package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 가로세로 길이 N
 * 2. N개 줄에 그림
 * 출력
 * 적록색약이 아닌 사람이 봤을 때의 구역의 수와 적록색약인 사람이 봤을 때의 구역의 수(공백으로 구분)
 * 조건
 * 적록색약은 빨-초를 구분하지 못함
 * 
 * >> dfs
 */
public class BJ_10026_적록색약_허은지 {
	static int N;
	static char[][] art;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		art = new char[N][N];
		visited = new boolean[N][N];
		int[] count = new int[2];
		
		for(int i = 0; i<N; i++) {
			art[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				//적록색약이 아닐 때
				if(!visited[i][j]) { 
					rgb(i, j, false);
					count[0]++;
				}
			}
		}
		
		//visited 초기화
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				//G는 모두 R로 바꿔 줌
				if(art[i][j]=='G') art[i][j] = 'R';
				 //적록색약일 때 탐색
				if(!visited[i][j]) {
					rgb(i, j, true);
					count[1]++;
				}
			}
		}
		
		System.out.println(count[0] + " " + count[1]);

	}

	//dfs
	private static void rgb(int i, int j, boolean isRGBilnd) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		visited[i][j] = true;
		
		//사방탐색
		for(int k = 0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			//배열 벗어나면 continue
			if(x<0 || x>=N || y<0 || y>=N) continue;
			//G는 모두 R로 바꿔 줌 => 여기에서만 하면 오류 남
			if(isRGBilnd && art[x][y]=='G') art[x][y] = 'R';
//			반례
//			2
//			GB
//			BG
			
			//원래 있던 값과 같고, 방문하지 않았다면 탐색
			if(art[i][j]==art[x][y] && !visited[x][y]) {
				rgb(x,y,isRGBilnd);
			}
		}
		
	}

}
