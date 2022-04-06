import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int M, N, H, arr[][][];
	static Queue<Node2> queue;
	static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static boolean[][][] visited;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		M = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(st.nextToken());

		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];
		queue = new LinkedList<>();
		visited = new boolean[H][N][M];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < M; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());

					if (arr[k][i][j] == 1) {
						queue.offer(new Node2(i, j,k, 1));
					}
				}
			}
		}

		bfs();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer - 1);
	}

	static void bfs() {

		while (!queue.isEmpty()) {

			Node2 node = queue.poll();

			answer = Math.max(answer, node.depth);

			visited[node.z][node.x][node.y] = true;

			for (int d = 0; d < 6; d++) {
				int dx = node.x + dir[d][0];
				int dy = node.y + dir[d][1];
				int dz = node.z + dir[d][2];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M && dz >= 0 && dz < H) {
					if (arr[dz][dx][dy] == 0 && !visited[dz][dx][dy]) {
						visited[dz][dx][dy] = true;
						arr[dz][dx][dy] = 1;
						queue.offer(new Node2(dx, dy, dz, node.depth + 1));
					}
				}
			}
		}
	}
}

class Node2 {
	int x;
	int y;
	int z;
	int depth;

	public Node2(int x, int y, int z, int depth) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.depth = depth;
	}

}
