import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int[][] arr;
	static int N, M, cnt;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(in.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = 1;
			arr[to][from] = 1;

		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static void bfs(int start) {

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				
				if(arr[current][i] == 1 && !visited[i]) {
					
					visited[i] = true;
					queue.offer(i);
					
				}
				
			}
		}

	}
}
