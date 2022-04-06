package lv24_DFS와BFS;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. N M 가로 세로
 * 2. N개의 줄에 M개의 정수로 미로
 * 출력
 * N M에 도착하는 최단거리
 * 
 * >> dfs cnt+1 넣어서 쓰기 => 시간초과
 * >> bfs
 */
public class s1_2178_미로탐색 {
	static int N, M, min;
	static int[][] maze;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		} //미로 초기화
		
		
		min = Integer.MAX_VALUE;
		
		//dfs(0, 0, count);
		bfs(0, 0);
		
		System.out.println(maze[N-1][M-1]);

	}

	private static void bfs(int i, int j) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[]{i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] ij = queue.poll();
			i = ij[0];
			j = ij[1];
			for(int k = 0; k<4; k++) {
				int x = i+dx[k];
				int y = j+dy[k];
				if(x<0 || x>=N || y<0 || y>=M) continue;
				if(maze[x][y] != 0 && !visited[x][y]) {
					queue.add(new int[]{x, y});
					visited[x][y] = true;
					maze[x][y] = maze[i][j] + 1;
				}
			}
		}
	}

//	private static void dfs(int i, int j, int count) {
//		int[] dx = {-1, 1, 0, 0};
//		int[] dy = {0, 0, -1, 1};
//		
//		visited[i][j] = true;
//		if(i==N-1 && j==M-1) {	
//			min = Math.min(count, min);
//		}
//		for(int k = 0; k<4; k++) {
//			int x = i + dx[k];
//			int y = j + dy[k];
//			if(x<0 || x>=N || y<0 || y>=M) continue;
//			if(maze[x][y]==1 && visited[x][y]==false) {
//				dfs(x, y, count+1);
//			}
//		}
//		visited[i][j] = false;
//	}

}
