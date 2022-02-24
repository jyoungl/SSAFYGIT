import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토2 {
	static int M, N, arr[][];
	static Queue<Node> queue;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		M = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		queue = new LinkedList<>();
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					queue.offer(new Node(i, j, 1));
				}
			}
		}
		

		
		bfs();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer-1);
	}

	static void bfs() {

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			answer = Math.max(answer, node.depth);
			
			visited[node.x][node.y] = true;

			for (int d = 0; d < 4; d++) {
				int dx = node.x + dir[d][0];
				int dy = node.y + dir[d][1];

				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (arr[dx][dy] == 0 && !visited[dx][dy]) {
						visited[dx][dy] = true;
						arr[dx][dy] = 1;
						queue.offer(new Node(dx, dy, node.depth + 1));
					}
				}
			}
		}
	}
}

