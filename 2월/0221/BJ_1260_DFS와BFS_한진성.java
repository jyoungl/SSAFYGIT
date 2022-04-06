import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int V = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		
		boolean[] visited = new boolean[N+1];
		Arrays.fill(visited, false);
		sb = new StringBuilder();
		// dfs
		dfs(V, visited, adjMatrix);
		sb.setLength(sb.length()-1);
		sb.append('\n');
		
		Arrays.fill(visited, false);
		
		bfs(V,visited, adjMatrix);

		System.out.println(sb);
		
	}
	public static void bfs(int v, boolean[] visited, int[][] adjMatrix) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[v] = true;
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			sb.append(current + " ");
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && adjMatrix[current][i] != 0) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
		
		sb.setLength(sb.length()-1);
		
	}
	
	public static void dfs(int v, boolean[] visited, int[][] adjMatrix) {
		visited[v] = true;
		sb.append(v + " ");
		for(int i=1;i<=N;i++) {
			if(!visited[i] && adjMatrix[v][i] != 0) {
				visited[i] = true;
				dfs(i, visited, adjMatrix);
			}
		}
	}
	
	
	
}
