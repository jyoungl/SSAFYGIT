package com.ssafy.im;

import java.util.*;
import java.io.*;

/**
 * 입력
 * 1. 테스트 케이스 T
 * 2. 고객의 수 N
 * 3. 회사의 좌표 x y, 집의 좌표 x y, N명의 고객의 좌표 x y ...
 * 
 * 출력
 * "#" + tc + " " + min
 * 
 * >> 회사에서 고객의 집을 모두 들른 뒤 집으로 감 N!
 * >> 모든 경우의 수를 찾아야 됨 순열
 */
public class D5_1247_최적경로_허은지 {
	static int N, sum, ans;
	static int[][] map; 
	static int[] cs;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D5_1247_최적경로.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[2][N+2]; //0은 무조건 회사 1은 무조건 집 ==> 손님이 N명이기 때문에 N+2 배열을 만들어줌
			cs = new int[N]; //배열의 index가 되는 수열을 만드는 배열
			isSelected = new boolean[N]; //수열을 만들기 위해 boolean값을 받는 배열
			ans = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N+2; i++) {
				map[0][i] = Integer.parseInt(st.nextToken()); //x좌표
				map[1][i] = Integer.parseInt(st.nextToken()); //y좌표
			}
			
			dfs(0);
			
			System.out.println("#" + tc + " " + ans);
		}
		
		
	}

	private static void dfs(int cnt) {
		if(cnt==N) { //N명 수열 전부 만들었을 때
			sum = 0;
			for(int i = 0; i<N-1; i++) {
				sum += Math.abs(map[0][cs[i]+2]-map[0][cs[i+1]+2]) + Math.abs(map[1][cs[i]+2]-map[1][cs[i+1]+2]);
				//i번째 손님과 i+1번째 손님 사이의 거리 구함
				//map[0][cs[i]] ==> 만들어진 수열의 값(0<=i<N)이 map의 index값이 되어
				//[0]일 때는 x좌표를, [1]일 때는 y좌표를 뽑는다
			}
			sum += Math.abs(map[0][0]-map[0][cs[0]+2]) + Math.abs(map[1][0]-map[1][cs[0]+2]); 		//첫 손님은 무조건 회사와 손님 사이의 거리 더함
			sum += Math.abs(map[0][1]-map[0][cs[N-1]+2]) + Math.abs(map[1][1]-map[1][cs[N-1]+2]); 	//마지막 손님은 무조건 집과 손님 사이의 거리 더함
			ans = Math.min(ans, sum); //sum의 최솟값 구하기
			return;
		}
		for(int i = 0; i<N; i++) { 		//손님의 숫자 크기 N만큼의 수열을 전부 뽑아서 돌림
			if(isSelected[i]) continue; // 이미 선택된 숫자면 continue
			
			cs[cnt] = i; 			//map 좌표의 index를 cs 배열에 넣어서 수열을 만듦
			isSelected[i] = true; 	//이미 썼기 때문에 true
			dfs(cnt+1);
			isSelected[i] = false;	 //다시 쓰기 위해 false
		}
		
	}

}
