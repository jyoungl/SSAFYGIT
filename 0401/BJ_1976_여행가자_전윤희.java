package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_1976_여행가자 {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 전체 도시 수
		int M = Integer.parseInt(br.readLine()); // 여행할 도시 수(중복허용)

		parent = new int[N + 1]; // 초기에, 본인은 본인 자신의 부모이다
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int isConnect = Integer.parseInt(st.nextToken()); // isConnect 가 0 이면 연결 되지 않은 상태이고, isConnect 가 1이면 연결 된 상태이다.
				// 연결된 부분은 합집합 연산
				if (isConnect == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken())); // 처음 시작 도시
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());

			// 맨 처음 출발 도시와 연결되어있지 않은 도시가 있으면
			// 여행 계획이 불가능한 것임.
			if (start != find(now)) {
				System.out.println("NO\n");
				return;
			}
		}
		System.out.println("YES\n");
	}

	// x의 부모를 찾아보자(재귀타면서 최종 부모를 찾음)
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

}
