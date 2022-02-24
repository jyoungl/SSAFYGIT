package com.baekjoon.study09;

import java.io.*;
import java.util.*;

public class dfsbfs_7576_토마토 {

	static int[][] arr; // 토마토 창고

	static int M; // 창고 가로
	static int N; // 창고 세로

	static int[] dr = { -1, 1, 0, 0 }; // 상하(행)
	static int[] dc = { 0, 0, -1, 1 }; // 좌우(열)

	static int day; // 토마토가 모두 익는데 걸리는 시간
	static Queue<position> queue; // 익은 토마토를 담을 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 창고 가로 6 (통상적으로 열)
		N = Integer.parseInt(st.nextToken()); // 창고 세로 4 (통상적으로 행)

		arr = new int[N][M];

		// 토마토 상태 배열 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		// System.out.println(Arrays.deepToString(map)); //for-each문을 써서 2차원 배열을 출력할 수 있지만, deepToString을 통해서도 가능함

		bfs();
	}

	private static void bfs() {

		// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
		queue = new LinkedList<position>(); // 익은 토마토를 담을 큐
		
		// 시작칸이 지정되지 않았으므로 반복문을 통해서 찾아준다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) { // 토마토가 익었다면
					queue.add(new position(i, j)); // 익은 토마토의 위치를 큐에 담음
				}
			}
		}

		while (!queue.isEmpty()) {
			position temp = queue.poll();

			for (int d = 0; d < 4; d++) { // 상하좌우 탐색
				int nr = temp.r + dr[d]; // 행
				int nc = temp.c + dc[d]; // 열

				// 범위를 벗어났다면 무시
				// 다음 위치에 있는 토마토가 이미 애초에 익은 토마토(1)거나 칸이 비어있으면(-1) 무시 
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] != 0) // 범위를 벗어났다면 무시
					continue; 

				// 그렇지않고 익지않은 토마토(0)라면, 익지않은 토마토는 현재(day) + 1 (2178_미로탐색 문제처럼 칸에 day를 저장)
				arr[nr][nc] = arr[temp.r][temp.c] + 1; // 현재일수 + 1
				queue.offer(new position(nr, nc));
			}
		}

		// 칸 안에 저장된 day 들 중 가장 큰 값을 꺼내보자
		// 날짜별 익은 토마토를 위에서 다 계산 해줬는데도 토마토가 모두 익지 못하는 상황이면, 배열 칸 안에 0이 있음
		day = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) { // 토마토가 모두 익지못하는 상황이면 -1을 출력
					System.out.println(-1);
					return;
				}
				day = Math.max(day, arr[i][j]); // 최대일수 구하기
			}
		}
		System.out.println(day - 1); // 1을 빼는 이유는 익은 토마토(1)에서 시작했기 때문에 day(시간) 자체는 day-1이 맞다
	}

	
	public static class position {
		int r;
		int c;

		public position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}