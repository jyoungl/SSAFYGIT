package com.baekjoon.study09;

import java.util.*;
import java.io.*;

//단지번호 문제랑 유사한듯
public class dfsbfs_1012_유기농배추 {

	static int T; // 테스트 케이스
	static int width; // 배열의 가로 길이
	static int height; // 배열의 세로 길이
	static int cabbage; // 배추 수

	static int[][] ground; // 배추를 심을 땅
	static boolean[][] visited;

	// 상우하좌(시계방향)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			width = Integer.parseInt(st.nextToken()); // 가로
			height = Integer.parseInt(st.nextToken()); // 세로
			cabbage = Integer.parseInt(st.nextToken()); // 배추 수

			// 문제에 나온 배추밭을 내가 편한 2차원 배열형태로 변형
			ground = new int[width][height];
			visited = new boolean[width][height];

			// 루프 돌면서 각각의 위치에 배추를 심어보자
			for (int j = 0; j < cabbage; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ground[r][c] = 1;
			}

			//Arrays.fill(visited, false); // 배열초기화 - 스터디/ 위에 다시 선언하니까 안해줘도 됨
			int goodworm = 0; // 배추흰지렁이의 수

			// 단지수 체킹과 유사
			// 이중 for 문을 돌면서, 배추가 있는 곳을 dfs로 탐색하면서 돈다
			for (int k = 0; k < width; k++) {
				for (int m = 0; m < height; m++) {
					if (!visited[k][m] && ground[k][m] == 1) { // 방문하지 않은 곳에 배추가 있으면
						dfs(k, m); // 주변 배추가 있는지 찾아본다
						goodworm++;
					}
				}
			}
			System.out.println(goodworm);
		}
	}

	static void dfs(int r, int c) {
		// 탐색했으니까 true
		visited[r][c] = true;

		// for 문을 돌면서 상하좌우 위치에 배추가 있는지 확인하고 배열
		// 에러가 안나게 체크부터 해준다.
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < width && nc < height) { // 범위체크
				if (!visited[nr][nc] && ground[nr][nc] == 1)
					dfs(nr, nc);
			}
		}
	}
}
