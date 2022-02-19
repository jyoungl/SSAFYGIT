import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int N;
	static boolean[] visited;

	//N이 1000까지라서 절대 flag XXXXXXXXXXXX
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");

		visited= new boolean[N+1];
		bfs(V);

		System.out.println(sb);

	}

	private static void bfs(int v) {
		visited[v] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);

		while(!queue.isEmpty()){
			v = queue.poll();
			sb.append(v).append(" ");
			for(int i=1;i<=N;i++){
				if(map[v][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;

		sb.append(v).append(" ");

		for(int i=1;i<=N;i++){
			if(map[v][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
