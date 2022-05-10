import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1938_통나무옮기기 {
	static int N;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N][2];

		int[][] dest = new int[3][2];
		int idx = 0;
		int way = 0;
		int[] tree = new int[2];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'E') dest[idx++] = new int[]{i, j};
				else if (map[i][j] == 'B') {
					way = tree[0] == i ? 0 : 1;
					tree[0] = i;
					tree[1] = j;
				}
			}
		}

		tree[0] = way == 0 ? tree[0] : tree[0] - 1;
		tree[1] = way == 0 ? tree[1] - 1 : tree[1];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{tree[0], tree[1], 0, way});
		visited[tree[0]][tree[1]][way] = true;

		int count = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			tree = queue.poll();
			way = tree[3];

			if (dest[1][0] == tree[0] && dest[1][1] == tree[1]) {
				if (way == 0 && (dest[0][0] == dest[1][0])) count = Math.min(count, tree[2]);
				else if (way == 1 && (dest[0][1] == dest[1][1])) count = Math.min(count, tree[2]);
			}

			if (moveU(way, tree)) {
				visited[tree[0] - 1][tree[1]][way] = true;
				queue.offer(new int[]{tree[0] - 1, tree[1], tree[2] + 1, way});
			}
			if (moveD(way, tree)) {
				visited[tree[0] + 1][tree[1]][way] = true;
				queue.offer(new int[]{tree[0] + 1, tree[1], tree[2] + 1, way});
			}
			if (moveL(way, tree)) {
				visited[tree[0]][tree[1] - 1][way] = true;
				queue.offer(new int[]{tree[0], tree[1] - 1, tree[2] + 1, way});
			}
			if (moveR(way, tree)) {
				visited[tree[0]][tree[1] + 1][way] = true;
				queue.offer(new int[]{tree[0], tree[1] + 1, tree[2] + 1, way});
			}
			if (moveT(tree)) {
				way = way == 0 ? 1 : 0;
				if (visited[tree[0]][tree[1]][way]) continue;
				visited[tree[0]][tree[1]][way] = true;
				queue.offer(new int[]{tree[0], tree[1], tree[2] + 1, way});
			}
		}

		System.out.println(count == Integer.MAX_VALUE ? 0 : count);
	}

	private static boolean moveT(int[] tree) {
		//범위, 1체크
		for (int i = tree[0] - 1; i <= tree[0] + 1; i++) {
			if (i < 0 || i >= N) return false;
			for (int j = tree[1] - 1; j <= tree[1] + 1; j++) {
				if (j < 0 || j >= N) return false;
				if (map[i][j] == '1') return false;
			}
		}

		return true;
	}

	private static boolean moveR(int way, int[] tree) {
		if (way == 0 && tree[1] + 2 < N && map[tree[0]][tree[1] + 2] != '1') {
			return !visited[tree[0]][tree[1] + 1][way];
		} else if (way == 1 && tree[1] + 1 < N) {
			for (int i = tree[0] - 1; i <= tree[0] + 1; i++) {
				if (i < 0 || i >= N) return false;
				if (map[i][tree[1] + 1] == '1') return false;
			}
			return !visited[tree[0]][tree[1] + 1][way];
		}
		return false;
	}

	private static boolean moveL(int way, int[] tree) {
		if (way == 0 && tree[1] - 2 >= 0 && map[tree[0]][tree[1] - 2] != '1') {
			return !visited[tree[0]][tree[1] - 1][way];
		} else if (way == 1 && tree[1] - 1 >= 0) {
			for (int i = tree[0] - 1; i <= tree[0] + 1; i++) {
				if (i < 0 || i >= N) return false;
				if (map[i][tree[1] - 1] == '1') return false;
			}
			return !visited[tree[0]][tree[1] - 1][way];
		}
		return false;
	}

	private static boolean moveD(int way, int[] tree) {
		if (way == 0 && tree[0] + 1 < N) {//가로
			for (int i = tree[1] - 1; i <= tree[1] + 1; i++) {
				if (i < 0 || i >= N) return false;
				if (map[tree[0] + 1][i] == '1') return false;
			}
			return !visited[tree[0] + 1][tree[1]][way];
		} else if (way == 1 && tree[0] + 2 < N && map[tree[0] + 2][tree[1]] != '1') {//세로
			return !visited[tree[0] + 1][tree[1]][way];
		}
		return false;
	}

	private static boolean moveU(int way, int[] tree) {
		if (way == 0 && tree[0] - 1 >= 0) {//가로
			for (int i = tree[1] - 1; i <= tree[1] + 1; i++) {
				if (i < 0 || i >= N) return false;
				if (map[tree[0] - 1][i] == '1') return false;
			}
			return !visited[tree[0] - 1][tree[1]][way];
		} else if (way == 1 && tree[0] - 2 >= 0 && map[tree[0] - 2][tree[1]] != '1') {//세로
			return !visited[tree[0] - 1][tree[1]][way];
		}
		return false;
	}

}
