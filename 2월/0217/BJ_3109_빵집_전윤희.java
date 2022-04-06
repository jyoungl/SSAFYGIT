package com.ssafy.im;

import java.util.*;
import java.io.*;

// 첫 번째 열에서 마지막 열까지 도달할 수 있는 최대 경로
// 단, 이 경로는 겹칠 수 없고 서로 접할 수도 없다.
// 재귀
// 다시 돌아오지 않아도 된다

public class BJ_3109_빵집 {

	static int R, C;
	static char[][] arr;

	// 오른쪽 위대각선, 오른쪽, 오른쪽 아래대각선
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };

	static boolean[][] check;
	static int cnt = 0; // 최대 경로 수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		// 배열 초기화
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 다시 방문한 곳은 재방문하면 안되므로 이를 체크하는 배열변수 생성
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) { // 행마다 붙잡고 체크
			if (go(i, 0))
				cnt++;
		}

		System.out.println(cnt);
	}

	// 첫 번째 열에서 행의 위치(위의 if문)를 변경한다
	// 벽을 피하고, 경로가 겹치지 않게 원웅이 빵집까지 도달할 수 있다면 true, 아니면 false를 반환
	// true 반환 시, 도달했다는 거니까 cnt + 1
	public static boolean go(int r, int c) {
		for (int i = 0; i < 3; i++) { // 방향 돌려주기
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < R && nc < C) { // 배열 범위 내에 있는지 체크
				if (check[nr][nc] == false && arr[nr][nc] == '.') { // 가지 않은 경로이고 벽이 아닐 때
					check[nr][nc] = true;
					if (nc == C - 1) // 원웅이 빵집(마지막 열)에 도착했으면
						return true; // 가스관 훔치기 완료
					if (go(nr, nc)) // 재귀 탄다
						return true;
				}
			}
		}
		return false;
	}
}
