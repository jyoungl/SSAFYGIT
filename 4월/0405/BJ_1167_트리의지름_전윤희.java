package com.ssafy.tree;

import java.io.*;
import java.util.*;

public class BJ_1167_트리의지름 {
	static int N;
	static int radius = 0;
	
	static boolean[] visited;
	static ArrayList<int[]>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 트리 정점의 개수
		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			tree[vertex] = new ArrayList<int[]>();
			while (true) {
				int vertexTo = Integer.parseInt(st.nextToken());
				if (vertexTo == -1)
					break;
				int distance = Integer.parseInt(st.nextToken());
				tree[vertex].add(new int[] { vertexTo, distance });
			}
		}
		
		visited[1] = true;
		dfs(1);
		
		System.out.println(radius);
	}
	
	private static int dfs(int v) {
		int maxRadius = 0;
		
		int[] arr = new int[tree[v].size()];
		//System.out.println(tree[v].size());
		for (int i = 0; i < tree[v].size(); i++) {
			int[] node = tree[v].get(i);
			
			if (!visited[node[0]]) {
				visited[node[0]] = true;
				int d = node[1] + dfs(node[0]);
				arr[i] = d;
				if (maxRadius < d)
					maxRadius = d;
			}
		}
		if (tree[v].size() > 1) {
			Arrays.sort(arr);
			int temp = arr[arr.length - 1] + arr[arr.length - 2];
			if (radius < temp)
				radius = temp;
		}
		
		if (radius < maxRadius)
			radius = maxRadius;
		return maxRadius;
	}
}
