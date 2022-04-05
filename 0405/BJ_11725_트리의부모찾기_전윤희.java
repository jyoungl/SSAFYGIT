package com.ssafy.tree;

import java.util.*;
import java.io.*;

// union-find로 찾으려다가 실패
// DFS로 1번 노드부터 해서 아래로 연결되어 있는 노드들을 쭉 탐색
// 아직 방문처리가 되지 않은 노드를 발견하면 자식노드로 처리한 후 
// 자식노드에 대한 자식을 찾기 위해 재귀로 DFS를 다시 호출한다.
public class BJ_11725_트리의부모찾기 {
	static int N;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			list[x].add(y);
			list[y].add(x);
		}

		dfs(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int v) {
		visited[v] = true;

		for (int vertex : list[v]) {
			if (!visited[vertex]) {
				parent[vertex] = v;
				dfs(vertex);
			}
		}
	}
}