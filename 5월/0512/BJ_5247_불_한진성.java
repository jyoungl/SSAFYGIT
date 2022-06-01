import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5247_불 {

	static class Node {
		int x;
		int y;
		int weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

	}

	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");

			int M = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(st.nextToken());

			char arr[][] = new char[N][M];

			for (int i = 0; i < N; i++) {
				arr[i] = in.readLine().toCharArray();
			}
			Queue<Node> queue = new LinkedList<>();
			Node node = null;
			boolean[][] visited = new boolean[N][M];
			boolean[][] visitedfire = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '*') {
						queue.offer(new Node(i, j, 1));
						visitedfire[i][j] = true;
					}

					if (arr[i][j] == '@') {
						node = new Node(i, j, 1);
						visited[i][j] = true;
					}
				}
			}
			boolean clear = false;
			queue.offer(node);

			while (!queue.isEmpty()) {

				Node temp = queue.poll();

				int x = temp.x;
				int y = temp.y;
				if (arr[x][y] == '@' || arr[x][y] == '!') {
//					System.out.println("x : " + x + " y : "+ y);
					if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
						clear = true;
						System.out.println(temp.weight);
						break;
					}
				}

				for (int d = 0; d < 4; d++) {

					int dx = x + dir[d][0];
					int dy = y + dir[d][1];
					if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
						continue;
					}
					if (arr[x][y] == '*') {
						if ((arr[dx][dy] == '.' || arr[dx][dy] == '@') && !visitedfire[dx][dy]) {
							
							if (arr[dx][dy] == '@') {
								arr[dx][dy] = '!';
							} else {
								arr[dx][dy] = '*';
							}
							visitedfire[dx][dy] = true;
							queue.offer(new Node(dx, dy, temp.weight + 1));
						}
					} else if ((arr[x][y] == '@' || arr[x][y] == '!') && !visited[dx][dy] && arr[dx][dy] == '.') {
						arr[dx][dy] = '@';
						visited[x][y] = true;
						if (arr[x][y] == '!') {
							arr[x][y] = '*';
						}
						visited[dx][dy] = true;
//						System.out.println(temp.weight+ " x : " + x + " y : " + y);
						queue.offer(new Node(dx, dy, temp.weight + 1));
					}
				}
			}
			if (!clear) {
				System.out.println("IMPOSSIBLE");
			}
		}

	}

}
