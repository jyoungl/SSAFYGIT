package com.ssafy.im;

import java.util.*;
import java.io.*;

//BFS
//문제 설명 조금 빈약해서 SWEA 댓글보고 수정함
//한사람만 있어도 무리로 처리해야 맞다고 나옴 
//서로 알고있지 않아도(=한사람만 알고있어도) 무리라고 처리해야 맞다고 나옴
public class D4_7465_창용마을무리의개수 {

	static int T; // 테스트케이스
	static int N; // 정점의 갯수
	static int line; // 간선의 갯수
	
	static int[][] graph;
	static boolean[] visited = new boolean[101];
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("input_D4_7465_창용마을무리의개수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			//System.out.println(N+" "+line);
			
			// 인접행렬
			graph = new int[N+1][N+1];
			for (int i = 0; i < line; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				//System.out.println(node1+" "+node2);
				
				//서로 알고있지 않아도(=한사람만 알고있어도) 무리라고 처리해야 맞다고 나옴
				graph[node1][node2] = 1;
				graph[node2][node1] = 1;
			}
			
			int company = 0; // 무리
			
			// 방문배열 초기화 (<< 필수. 안해주면 두번째 아웃풋 제대로 안나옴)
			for (int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
			
			for (int i = 1; i <= N; i++) { // 시작노드를 정하지 않았으므로
				if(!visited[i]) { // 방문하지 않았다면
					bfs(i);
					company++; //한사람만 있어도 무리로 처리해야 맞다고 나옴
				}
			}
			System.out.println("#" + tc + " " + company);
		}
	}

	private static void bfs(int startNode) {
		queue.add(startNode);
		visited[startNode] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if(graph[now][i] == 1 && !visited[i]) { // 인접행렬에서 대각선 아니고, 연결되어있는데 방문하지 않은 곳이라면
					visited[i] = true; // 방문해준다
					queue.add(i);
				}
			}
		}
		
	}

}
