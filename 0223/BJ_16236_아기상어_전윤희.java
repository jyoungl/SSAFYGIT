package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_16236_아기상어 {
	
	static int[][] ground;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 어장의 크기(N×N)

		ground = new int[N][N]; // 어장 배열 변수 생성
		int[] now = null; // 상어의 위치

		// 어장 초기화(input)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ground[i][j] == 9) {// 아기 상어
					//상어의 위치를 저장하고, 그자리를 공석으로 초기화
					//매번 상어가 이동할때마다 0으로 초기화하기 귀찮아서 미리 함
					now = new int[] { i, j };
					ground[i][j] = 0;
				}
			}
		}

		int size = 2; // 상어 (초기) 크기
		int eat = 0; // 먹은 물고기 개수
		int move = 0; // 움직인 거리

		// 상좌우하
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		
		// 먹을때마다 상어의 위치가 갱신
		while (true) {
			// 우선순위 : 거리가 가깝거나, 가장 위에 있거나, 가장 왼쪽에 있는 물고기 순
			// int[] = {행(y좌표), 열(x좌표), 이동거리}
			PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
			boolean[][] visit = new boolean[N][N];

			que.add(new int[] { now[0], now[1], 0 }); // 행(y좌표), 열(x좌표), 이동한 거리
			visit[now[0]][now[1]] = true;

			// 모든 위치(상어가 갈 수 있는 모든 위치)를 돌았을 때 물고기를 먹었는지 먹지 않았는지 판별
			boolean check = false; // 아기상어가 먹이를 먹었니?

			eat:
				while (!que.isEmpty()) {
				now = que.poll(); // 아기상어 출발

				if (ground[now[0]][now[1]] != 0 && ground[now[0]][now[1]] < size) { // 먹이가 있고, 그 먹이가 상어보다 사이즈가 작다면
					ground[now[0]][now[1]] = 0; // 물고기를 제거
					eat++; // 아기상어 식사 냠냠
					move = move + now[2]; // 움직인 거리를 총 움직인 거리에 추가
					check = true; // 위에 식사했으므로 먹이 먹었다고 체크
					break eat;
				}

				search: // 사방탐색
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + dr[d];
					int nc = now[1] + dc[d];

					if (nr < 0 || nc < 0 || nc >= N || nr >= N || visit[nr][nc] || ground[nr][nc] > size) // 배열 범위를 벗어나거나, 이미 방문한 곳이거나, 상어보다 사이즈가 큰 물고기가 있을 때 재탐색(지나갈 수 없음)
						continue search;

					que.add(new int[] { nr, nc, now[2] + 1 }); // 위의 if문 조건에 안걸린다면 지나갈 수 있음
					visit[nr][nc] = true;
				}
			}

			if (!check) // 큐가 비워질 때까지 먹이를 먹은적이 없다면, 더 이상 먹은 물고기가 없으므로 엄마상어에게 HELP
				break; // 가장 큰 while 문 탈출

			if (size == eat) { // 사이즈와 먹이를 먹은 수가 동일하다면 상어의 크기를 증가
				size++;
				eat = 0;
			}
		}

		System.out.println(move);

	}

}
