import java.io.*;
import java.util.*;

public class BOJ_7576_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] tomato = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) queue.offer(new int[]{i, j});
			}
		}

		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		int depth = 0;
		int[] v;
		while (!queue.isEmpty()) {
			v = queue.poll();
			depth = Math.max(depth, tomato[v[0]][v[1]]-1);

			for (int d = 0; d < 4; d++) {
				int ny = v[0] + deltas[d][0];
				int nx = v[1] + deltas[d][1];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || tomato[ny][nx] != 0) continue;
				tomato[ny][nx] = tomato[v[0]][v[1]] + 1;
				queue.offer(new int[]{ny, nx});
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(depth);

	}
}
