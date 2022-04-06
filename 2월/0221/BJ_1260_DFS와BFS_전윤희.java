package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1260_DFS와BFS {

	static int N; // 정점의 갯수
	static int line; // 간선의 갯수

	static int[][] graph;
	static boolean[] visited = new boolean[1001]; // 정점의 개수가 최대 1000개

	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] token = br.readLine().split(" ");

		N = Integer.parseInt(token[0]); // 정점 수 : 4
		line = Integer.parseInt(token[1]); // 간선 수 : 5
		int startNode = Integer.parseInt(token[2]); // 탐색을 시작할 정점의 번호 : 1

		graph = new int[N + 1][N + 1]; // 인접행렬

		for (int i = 0; i < line; i++) {
			token = br.readLine().split(" "); // 배열 재정의
			int node1 = Integer.parseInt(token[0]);
			int node2 = Integer.parseInt(token[1]);

			// 무향 그래프
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}

		sb = new StringBuilder();
		
		dfs(startNode);
		sb.append("\n");
		
		// 방문배열 초기화
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		bfs(startNode);
		
		System.out.println(sb);
	}

	/**
	 *   1 2 3 4
	 * 1 0 1 1 1
	 * 2 1 0 0 1
	 * 3 1 0 0 1
	 * 4 1 1 1 0
	 */
	private static void bfs(int startNode) {
		queue.add(startNode); // 1
		visited[startNode] = true;

		while (!queue.isEmpty()) { // 큐가 텅텅 빌 때까지
			startNode = queue.poll();
			sb.append(startNode).append(" ");

			for (int i = 1; i <= N; i++) {
				if (graph[startNode][i] == 1 && !visited[i]) { // 인접행렬에서 행 고정하고 가로방향 체크
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		queue.clear();
	}

	private static void dfs(int startNode) {
		visited[startNode] = true; // 들어왔으니 true
		sb.append(startNode).append(" ");

		// 유도파트
		for (int i = 1; i <= N; i++) {
			if (graph[startNode][i] == 1 && !visited[i]) { // 간선으로 연결되어 있는데 방문 안한 경우
				dfs(i);
			}
		}
	}

}
