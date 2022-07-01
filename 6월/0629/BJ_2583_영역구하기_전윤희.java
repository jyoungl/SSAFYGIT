package 기타;

import java.io.*;
import java.util.*;

public class BJ_2583_영역구하기 {
	static int R, C, K;
	static int[][] arr;
	static boolean[][] isVisited;
	static int[][] pos;
	static int width, height;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static StringBuilder sb = new StringBuilder();

	static ArrayList<Integer> list;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		isVisited = new boolean[R][C];
		pos = new int[K + 1][4]; // [n번째사각형][좌표]

		width = 0;
		height = 0;
		// 색칠하기
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken()); // 사각형 왼쪽 꼭지점 r좌표
			pos[i][1] = Integer.parseInt(st.nextToken()); // 사각형 왼쪽 꼭지점 c좌표
			pos[i][2] = Integer.parseInt(st.nextToken()); // 사각형 오른쪽 꼭지점 r좌표
			pos[i][3] = Integer.parseInt(st.nextToken()); // 사각형 오른쪽 꼭지점 c좌표

			width = pos[i][3] - pos[i][1];
			height = pos[i][2] - pos[i][0];
			int startPointR = pos[i][0];
			int startPointC = pos[i][1];
			for (int r = startPointR; r < startPointR + height; r++) {
				for (int c = startPointC; c < startPointC + width; c++) {
					// 이미 색칠한 부위(1)라면 건너 뛰기
					if (arr[r][c] == 1)
						continue;
					arr[r][c] = 1;
				}
			}
		}

		// debug
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0 && !isVisited[i][j]) {
					cnt = 0; // 덩어리 세는 변수
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer area : list) {
			System.out.print(area + " ");
		}
	}

	private static void dfs(int r, int c) {
		isVisited[r][c] = true;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위초과하면 리턴
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			
			if (arr[nr][nc] == 0 && !isVisited[nr][nc]) {
				dfs(nr, nc);
			}

		}

	}

}
