package com.ssafy.im;

import java.util.*;
import java.io.*;

//unionFind
//union : x와 y가 포함되어 있는 집합을 합치는 연산
//find : x가 어떤 집합에 포함되어 있는지 찾는연산
public class D4_3289_서로소집합 {

	static int T; // 테스트케이스
	static int n, m;
	static int type, a, b;

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D4_3289_서로소집합.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 자신의 부모노드를 자신의 값으로 세팅
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}

			System.out.print("#" + tc + " ");

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (type == 1) { // a와 b가 서로 같은 집합인지 검사
					if (find(arr, a, b)) // 같은 집합에 속해있다면
						System.out.print(1);
					else // 다른 집합에 속해 있다면
						System.out.print(0);
				} else { // 합집합
					union(arr, a, b);
				}
			}
			System.out.println();
		}

	}

	private static void union(int[] parent, int x, int y) {
		x = findSet(parent, x);
		y = findSet(parent, y);

		// 같은 부모를 가지고 있지 않을 때
		if (x > y)
			parent[x] = y;
		else
			parent[y] = x;

	}

	private static boolean find(int[] parent, int x, int y) {
		return (findSet(parent, x) == findSet(parent, y));
	}

	private static int findSet(int[] parent, int x) {
		if (x == parent[x])
			return x; // 모든 값이 자기 자신을 가리킴
		else
			return parent[x] = findSet(parent, parent[x]); // 최초의 부모(대표)를 찾아 재귀탄다
	}

}
