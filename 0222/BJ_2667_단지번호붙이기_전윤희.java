package com.baekjoon.study09;

import java.util.*;
import java.io.*;

public class dfsbfs_2667_단지번호붙이기 {

	static int N; // 지도의 크기 (N×N)
	static int[][] map;
	static boolean[][] visited;

	static int[] count = new int[625]; // 단지 내 아파트 개수 세기위한 변수
	static int village = 0; // 단지 수

	// 상우하좌(시계방향)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		// toCharArray 쓰면 될 것을··· 떼잉
		// 배열 초기화 -> java.util.NoSuchElementException
		for (int i = 0; i < N; i++) {
			//st = new StringTokenizer(br.readLine(), "");
			String[] s = br.readLine().split("");
			//String s = br.readLine();
			for (int j = 0; j < N; j++) {
				//map[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = Integer.parseInt(s[j]);
				/*
				map[i][j] = Integer.parseInt(s.charAt(j));
				>> parseInt(String)
				map[i][j] = s.charAt(j);
				*/
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) { // 방문하지 않은 곳에 집이 있으면
					village++;
					dfs(i, j);
				}
			}
		}

		Arrays.sort(count); // 오름차순 정렬
		
		System.out.println(village); // 단지 수 출력
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				System.out.println(count[i]);
		}
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;

		count[village]++;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 배열범위 체크
				if (!visited[nr][nc] && map[nr][nc] == 1)
					dfs(nr, nc);
			}

		}
	}

}
