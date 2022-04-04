package com.ssafy;

import java.io.*;
import java.util.*;

public class BJ_20040_사이클게임 {
	static int N, M;
	static int result;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 점의 개수
		M = Integer.parseInt(st.nextToken()); // 시도 횟수

		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 사이클이 형성되는지 확인
			if (!union(a, b)) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

	// union과 sameParent 함수 합침
	private static boolean union(int a, int b) {
		int aRoot = find(a); // a의 root 노드
		int bRoot = find(b); // b의 root 노드
		// a와 b의 root 노드가 같다면 사이클 형성
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = find(parents[n]);
	}

}