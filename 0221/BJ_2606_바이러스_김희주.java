import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	static int N;
	static boolean[] visited;
	static int[][] computers;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		computers = new int[N+1][N+1];
		visited = new boolean[N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computers[a][b] = computers[b][a] = 1;
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);

		int cnt = 0;
		visited[1] = true;

		while(!queue.isEmpty()){
			int v = queue.poll();
			for(int i=1;i<=N;i++){
				if(computers[v][i]==1 && !visited[i]){
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
		return cnt;
	}
}
