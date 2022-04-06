import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M;
	static char[][] arr;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine().toCharArray();
		}

		int A1 = bfs(new Node(0, 0, 1, false), new boolean[N][M][2]);

		System.out.println(A1);

	}

	static int bfs(Node node, boolean[][][] visited) {

		Queue<Node> queue = new LinkedList<>();

		queue.offer(node);

		visited[node.x][node.y][0] = true;
		while (!queue.isEmpty()) {

			Node temp = queue.poll();
			if (temp.x == N - 1 && temp.y == M - 1) {
				return temp.depth;
			}

			for (int d = 0; d < 4; d++) {
				int dx = temp.x + dir[d][0];
				int dy = temp.y + dir[d][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (arr[dx][dy] == '0') {
						if (!temp.crash && !visited[dx][dy][0]) {
							//
							visited[dx][dy][0] = true;
							queue.offer(new Node(dx, dy, temp.depth + 1, false));
						} else if (temp.crash && !visited[dx][dy][1]) {
							visited[dx][dy][1] = true;
							queue.offer(new Node(dx, dy, temp.depth + 1, true));
						}
					} else if (arr[dx][dy] == '1') {
						if (!temp.crash) {
							queue.offer(new Node(dx, dy, temp.depth + 1, true));
							visited[dx][dy][1] = true;
						}

					}
				}
			}
		}
		return -1;
	}
}

class Node {

	int x;
	int y;
	boolean crash;
	int depth;

	public Node(int x, int y, int depth) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

	public Node(int x, int y, int depth, boolean crash) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.crash = crash;
	}

}
