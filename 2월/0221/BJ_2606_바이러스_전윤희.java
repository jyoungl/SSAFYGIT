package com.baekjoon.study09;

import java.util.*;
import java.io.*;

public class dfsbfs_2606_바이러스 {

	static int computer; // 정점의 수
	static int line; // 간선의 수

	static int[][] graph;
	static boolean[] visited = new boolean[101]; // 정점의 개수가 최대 100개

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		computer = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		int startNode = 1; // 탐색을 시작할 정점의 번호 : 1

		String[] token;
		graph = new int[computer + 1][computer + 1];

		// 인접행렬 완성하기
		for (int i = 0; i < line; i++) {
			token = br.readLine().split(" ");
			int node1 = Integer.parseInt(token[0]);
			int node2 = Integer.parseInt(token[1]);

			// 무향 그래프
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}

		dfs(startNode);
		
		int count = 0; 
		for (int i = 2; i < visited.length; i++) { // 1번 컴퓨터를 통해 웜바이러스를 걸리는 컴퓨터 수를 출력하므로
			if(visited[i]==true)
				count++;
		}
		System.out.println(count);
	}

	private static void dfs(int startNode) {
		visited[startNode] = true; // 들어왔으니 true

		// 유도파트
		for (int i = 1; i <= computer; i++) {
			if (graph[startNode][i] == 1 && !visited[i]) { // 간선으로 연결되어 있는데 방문 안한 경우
				dfs(i);
			}
		}

	}

}
