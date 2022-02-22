package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 마을에 사는 사람 수 N 서로를 알고 있는 사람의 관계 수 M
 * 3. M개의 줄에 서로를 알고 있는 사람의 번호(양방향)
 * 출력
 * 무리의 개수
 * 
 * >> 서로 아는 사람이 연결되어 있으면 한 무리로 계산
 * >> for 돌려서 start 지점 바꾸기
 */
public class D4_7465_창용마을무리의개수_허은지 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D4_7465_창용마을무리의개수.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][N+1];
			boolean[] visited = new boolean[N+1];
			
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				arr[from][to] = arr[to][from] = 1;
			}
			
			int ans = 0;
			
			for(int i = 1; i<N+1; i++) {
				if(!visited[i]) {
					dfs(arr, visited, i);
					ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);

	}//main
	
	private static void dfs(int[][] arr, boolean[] visited, int start) {
		visited[start] = true;
		for(int i = 1; i<N+1; i++) {
			if(arr[start][i]==1 && !visited[i]) dfs(arr, visited, i);
		}
		
	}//dfs
	
}//class
