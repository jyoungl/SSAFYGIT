import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Queue<int[]> queue;
		Queue<int[]> fqueue;

		char[][] map;
		int[][] fire;
		int W, H;
		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			fire = new int[H][W];

			boolean[][] visited = new boolean[H][W];
			queue = new ArrayDeque<>();
			fqueue = new ArrayDeque<>();
			boolean result = false;
			int[] pos;
			int ni, nj;

			for (int i = 0; i < H; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '@') {
						queue.offer(new int[]{i, j, 1});
						visited[i][j] = true;
						map[i][j]='.';
						if (i == 0 || i == H - 1 || j == 0 || j == W - 1) {
							sb.append("1\n");
							result = true;
						}
					} else if (map[i][j] == '*') {
						fqueue.offer(new int[]{i, j, 1});
						fire[i][j] = 1;
					}
				}
			}


			while (!fqueue.isEmpty() && !result) {
				pos = fqueue.poll();

				for (int d = 0; d < 4; d++) {
					ni = pos[0] + deltas[d][0];
					nj = pos[1] + deltas[d][1];

					if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] != '#' && fire[ni][nj] == 0) {
						fire[ni][nj] = pos[2] + 1;
						fqueue.offer(new int[]{ni, nj, pos[2] + 1});
					}
				}
			}

			while (!queue.isEmpty() && !result) {
				pos = queue.poll();

				for (int d = 0; d < 4; d++) {
					ni = pos[0] + deltas[d][0];
					nj = pos[1] + deltas[d][1];

					if (ni >= 0 && ni < H && nj >= 0 && nj < W && !visited[ni][nj] && (fire[ni][nj]==0 || fire[ni][nj] > pos[2]+1) && map[ni][nj] != '#') {
						if (ni == 0 || ni == H - 1 || nj == 0 || nj == W - 1) {
							sb.append(pos[2] + 1).append('\n');
							result = true;
							break;
						}
						queue.offer(new int[]{ni, nj, pos[2] + 1});
						visited[ni][nj] = true;
					}
				}
			}

			if (!result) sb.append("IMPOSSIBLE\n");
		}
		System.out.print(sb);
	}
}
