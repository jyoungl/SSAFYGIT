package lv24_DFS와BFS;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 정점의 개수 N 간선의 개수 M 탐색을 시작할 정점 V
 * 2. 간선이 연결하는 두 정점의 번호
 * 출력
 * 1. DFS(깊이 우선 탐색)
 * 2. BFS(너비 우선 탐색)
 * 
 * >> DFS: 스택이나 재귀
 * 		>> 한 노드에서 갈 수 있는 노드 중 하나를 선택한다
 * 		>> 선택한 노드에서 갈 수 있는 노드 중 하나를 선택한다 이때 이미 방문한 노드는 제외하고 선택한다
 * 		>> 갈 수 있는 노드가 존재하지 않으면 이전 노드로 돌아와서 갈 수 있는 노드 중 하나를 선택한다
 * >> BFS: 큐
 * 		>> 한 노드에서 갈 수 잇는 노드를 큐에 추가한다
 * 		>> 큐에서 노드를 하나 꺼내 꺼낸 노드에서 갈 수 있는 노드를 큐에 추가한다
 * 		>> 한 포인트에서 갈 수 있는 모든 포인트를 다 넣고 탐색을 끝나면 그 다음 포인트(poll())에서 갈 수 있는 포인트 탐색
 * 		>> 큐에 노드가 존재하지 않으면 break 한다
 */
public class s2_1260_DFS와BFS {
	static int N, M, V;
	static int[][] arr;
	static boolean[] checkDFS, checkBFS;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//정점 번호가 1부터 N+1이기 때문에 +1씩 해 줌
		arr = new int[N+1][N+1];
		checkDFS = new boolean[N+1];
		checkBFS = new boolean[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			arr[num1][num2] = arr[num2][num1] = 1; //간선이 양방향이기 때문에 둘 다 저장해 줌
		}
		
		dfs(V);
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb);

	}

	private static void dfs(int start) {
		sb.append(start).append(" ");
		for(int i = 0; i<N+1; i++) {
			checkDFS[start] = true; //start를 체크
			if(arr[start][i] == 1 && checkDFS[i] == false) //start와 i를 잇는 간선이 있는지, i가 방문한 적 없는 곳인지 체크
			dfs(i); // 둘 다 해당되면 i로 내려감
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); //시작점을 큐에 넣음
		checkBFS[start] = true; //start를 체크
		sb.append(start).append(" ");
		
		while(!queue.isEmpty()) { //큐가 모두 빌 때까지 돌림
			start = queue.poll(); //큐에서 노드 하나를 꺼냄
			for(int i = 0; i<N+1; i++) {
				if(arr[start][i] == 1 && checkBFS[i] == false) { //start와 i를 잇는 간선이 있는지, i가 방문한 적 없는 곳인지 체크
					queue.add(i); // 둘 다 해당되면 queue에 추가
					checkBFS[i] = true; // 갔다고 체크
					sb.append(i).append(" "); // 출력
				}
			}
		}
	}

}
