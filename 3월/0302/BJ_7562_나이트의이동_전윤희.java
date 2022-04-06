package com.baekjoon.study09;

import java.util.*;
import java.io.*;

class Position {
	
	int x, y;

	public Position(int x, int y) { // 생성자
		this.x = x;
		this.y = y;
	}
}

public class dfsbfs_7562_나이트의이동 {
	
	static int[][] chess; // 체스판
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int i = 0; i < T; i++) {
			int I = Integer.parseInt(br.readLine()); // 체스판 크기
			chess = new int[I][I]; // 초기화

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Position start = new Position(x, y); // 출발 지점

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Position end = new Position(x, y); // 목표 지점

			bfs(start, end, I);
		}

		System.out.print(sb); // 이동 횟수 출력
	} 

	static void bfs(Position start, Position end, int I) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(start);
		chess[start.x][start.y] = 1; // 시작 위치 1로 지정

		// 나이트가 이동 할 수 있는 탐색 범위
		int[] dx = { 2, 2, 1, 1, -1, -2, -1, -2 };
		int[] dy = { -1, 1, -2, 2, -2, -1, 2, 1 };
		
		Position pos;
		while (!queue.isEmpty()) {
			pos = queue.poll();
			int x = pos.x;
			int y = pos.y;

			// 목표지점에 도착했으면 시작위치 -1해준 값(시작위치를 1로 시작했으므로)을 넣어줌
			if (x == end.x && y == end.y)
				sb.append(chess[x][y] - 1 + "\n");

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i]; // 다음 x
				int ny = y + dy[i]; // 다음 y
				
				if (nx < 0 || ny < 0 || nx >= I || ny >= I)
					continue; // 범위 확인
				if (chess[nx][ny] > 0)
					continue; // 방문한 적 있는지 확인

				queue.offer(new Position(nx, ny));
				chess[nx][ny] = chess[x][y] + 1; // 그 전 값 +1
			} 
		} 
	} 
} 
