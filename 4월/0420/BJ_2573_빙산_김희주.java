import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	static int N, M, TOTAL;
	static int[][] sea;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sea = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 0; m < M; m++) {
				sea[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt,time = 0;
		while (true){
			cnt = melt();
			time++;
			if(TOTAL==0){
				System.out.println(0);
				return;
			}
			if(TOTAL!=cnt) {
				System.out.println(time);
				return;
			}
		}
	}

	private static int melt() {
		TOTAL = 0;
		int[][] next = new int[N][M];
		int tmp, ni, nj;
		int n = 0, m = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (sea[i][j] == 0) continue;
				tmp = 0;
				for (int d = 0; d < 4; d++) {
					ni = i + deltas[d][0];
					nj = j + deltas[d][1];
					if (ni < 0 || ni >= N || nj < 0 || nj >= M || sea[ni][nj] > 0) continue;
					tmp++;
				}
				next[i][j] = sea[i][j]-Math.min(tmp,sea[i][j]);
				if (next[i][j] != 0) {
					if (n == 0 && m == 0) {
						n = i;
						m = j;
					}
					TOTAL++;
				}
			}
		}
		sea = next;
		visited = new boolean[N][M];
		return dfs(n,m);
	}

	private static int dfs(int i, int j) {
		int cnt = 1;
		visited[i][j] = true;

		int ni, nj;
		for (int d = 0; d < 4; d++) {
			ni = i + deltas[d][0];
			nj = j + deltas[d][1];
			if (ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj] || sea[ni][nj] == 0) continue;
			cnt += dfs(ni, nj);
		}

		return cnt;
	}
}
