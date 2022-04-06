package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {

	/*
	 * 1. 테스트케이스 T
	 * 2. 정수 N => N*N방을 만듦
	 * 3. N*N 방에 있는 수 나옴
	 * 4. +1만큼 이동하는데 
	 * 5. 결과값이 같으면 처음 시작한 수가 작은 것으로 출력 >> 
	 * 6. 출력: "#" + tc + " " + 처음출발하는방번호 + " " + 최대몇개의방(자신포함)
	 * 
	 * >> 함수 재귀 써서 풀기(dfs랑 비슷하게)
	 */
	static int N;
	static int[][] map;
	static int[][] count;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_1861_정사각형방.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			count = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //Map 만들기
			
			int max = 0;
			int result = 0;
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(count[i][j]==0) {
						plus1(i, j);
					}		
					
					if(max < count[i][j]) { //MAX값 구하기
						max = count[i][j];
						result = map[i][j];		
					} else if(max==count[i][j]) { //같을 때는
						if(result > map[i][j]) result = map[i][j]; //더 작은 값으로 구하기
					}
					
				}
			}
			System.out.println("#" + tc + " " + result + " " + max);
		} //tc
	} //Main
	
	public static void plus1(int i, int j) {
		count[i][j] = 1;
		
		for(int k = 0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) { //배열을 벗어나면 continue
				continue;
			}
			if(map[nx][ny] == map[i][j] + 1) { //1을 더한 값을 찾았을 때
				plus1(nx, ny); //그곳에서 다시 plus1 함수 호출
				count[i][j] = Math.max(count[i][j], count[nx][ny]+1); //결과값 큰 것 구하기
			}
		}
	}
	
} //Class
