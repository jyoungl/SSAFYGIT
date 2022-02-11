package com.ssafy.im;

import java.io.*;

public class BJ_16926_배열돌리기1 {

	static int R, C, rotate, layer;
	// 우하좌상 (반시계 방향)
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] condition = br.readLine().split(" ");
		R = Integer.parseInt(condition[0]);
		C = Integer.parseInt(condition[1]);
		rotate = Integer.parseInt(condition[2]);

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

		layer = Math.min(R, C) / 2; // 회전가능한 바깥~안쪽 껍질의 수
		for (int i = 0; i < rotate; i++) {
			rotateArr();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

		br.close();
	}

	private static void rotateArr() {
		
		for (int i = 0; i < layer; i++) {
			int temp = arr[i][i]; // [0][0](가장 바깥 껍질), [1][1] (그 다음 안쪽 껍질) ···

			int dir = 0;
			int r = i;
			int c = i;
			while (dir < 4) { // 우하좌상 ← ↓ → ↑
				// 한 칸 이동
				int nr = r + dr[dir]; 
				int nc = c + dc[dir]; 

				// 다음 칸 좌표 확인
				if (nr >= i && nr < R - i && nc >= i && nc < C - i) {
					arr[r][c] = arr[nr][nc]; // 이전 점의 값을 다음 점의 값으로 치환
					r = nr; // 현재 점을 다음 점의 값으로 바꾸고 while문으로 다시 감
					c = nc;
				} else {
					dir++; // 다음 점이 범위를 벗어났으므로 꺾음
				}

			}

			arr[i + 1][i] = temp;
		}

	}

}
