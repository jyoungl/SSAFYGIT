import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(in.readLine());
				for (int m = 0; m < M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					if (tomato[h][n][m] == 1) queue.offer(new int[]{h, n, m});
					if(tomato[h][n][m]>=0) ++count;
				}
			}
		}
		int[][] deltas = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};

		int depth = 0;
		int[] v;
		while (!queue.isEmpty()) {
			v = queue.poll();
			depth = Math.max(depth, tomato[v[0]][v[1]][v[2]] - 1);
			--count;

			for (int d = 0; d < 6; d++) {
				int nh = v[0] + deltas[d][0];
				int ny = v[1] + deltas[d][1];
				int nx = v[2] + deltas[d][2];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || nh < 0 || nh >= H || tomato[nh][ny][nx] != 0) continue;
				tomato[nh][ny][nx] = tomato[v[0]][v[1]][v[2]] + 1;
				queue.offer(new int[]{nh, ny, nx});
			}
		}

		//메모리 12952, 시간 760ms
//		for (int h = 0; h < H; h++) {
//			for (int n = 0; n < N; n++) {
//				for (int m = 0; m < M; m++) {
//					if (tomato[h][n][m] == 0) {
//						System.out.println(-1);
//						return;
//					}
//				}
//			}
//		}

//		System.out.println(depth);

		//메모리 130244, 시간 680ms
		System.out.println(count==0?depth:-1);

	}
}
