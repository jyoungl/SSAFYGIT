import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});

		int[] v;
		while (!queue.isEmpty()) {
			v = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ni = v[0] + deltas[d][0];
				int nj = v[1] + deltas[d][1];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && maze[ni][nj] != 0
						&& (maze[ni][nj] > maze[v[0]][v[1]] + 1 || maze[ni][nj] == 1)) {
					maze[ni][nj] = maze[v[0]][v[1]] + 1;
					queue.offer(new int[]{ni, nj});
				}
			}

		}

		System.out.println(maze[N - 1][M - 1]);

	}
}
