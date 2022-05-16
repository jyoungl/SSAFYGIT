import java.io.*;
import java.util.*;

public class BOJ_2638_치즈 {
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] visited;
	static boolean[][] map;
	static int N, M, cheese;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new int[N][M];
		map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1';
				if (map[i][j]) cheese++;
			}
		}

		int time = 0;
		while (cheese > 0) {
			melt();
			time++;
		}
		System.out.println(time);
	}

	private static void melt() {
		queue.offer(new int[]{0, 0});
		int[] now;
		int nn, nm;
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int d = 0; d < 4; d++) {
				nn = now[0] + deltas[d][0];
				nm = now[1] + deltas[d][1];
				if (nn < 0 || nn >= N || nm < 0 || nm >= M || (!map[nn][nm] && visited[nn][nm]>0)) continue;
				else if (!map[nn][nm]) {//빈 공간일때
					queue.offer(new int[]{nn, nm});
				}
				visited[nn][nm]++;
			}
		}

		//없애기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] && visited[i][j]>=2){
					map[i][j] = false;
					cheese--;
				}
				visited[i][j] = 0;
			}
		}
	}

}
