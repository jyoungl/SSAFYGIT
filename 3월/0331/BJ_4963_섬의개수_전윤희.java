package com.ssafy.A;

import java.io.*;
import java.util.*;

/** 틀린 이유
 
	go 조건
	if (map[nr][nc] == 1) {
			go(nr, nc);
		}
		
	행, 열 잘 보기(문제)
	map = new int[h][w];
	
	배열초기화
	visited = new boolean[h][w];
	
 */
public class BJ_4963_섬의개수 {
	static int w, h;
	static int[][] map;
	static int count;

	static boolean[][] visited;

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		whole: while (true) {
			w = in.nextInt();
			h = in.nextInt();

			if (w == 0 && h == 0) // 입력의 마지막 줄에는 0이 두 개
				break whole;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = in.nextInt();
				}
			}

//			for (int i = 0; i < w; i++) {
//				for (int j = 0; j < h; j++) {
//					System.out.println(map[i][j]+" ");
//				}
//				System.out.println();
//			}

			visited = new boolean[h][w];
			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						go(i, j);
						count++;
					}
				}
			}
			// sb.append(count+"\n");
			System.out.println(count);
		}
		// System.out.println(sb);
	}

	private static void go(int r, int c) {
		// 기저조건

		// 유도파트
		visited[r][c] = true;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 > nr || nr >= h || 0 > nc || nc >= w)
				continue;
			if (visited[nr][nc] == true)
				continue;
			if (map[nr][nc] == 1) {
				go(nr, nc);
			}
		}
		return;
	}

}
