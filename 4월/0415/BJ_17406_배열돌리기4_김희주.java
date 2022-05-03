import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//우-하-좌-상
	static int[][] A;
	static int[][] command;
	static int N, M, K, MIN = Integer.MAX_VALUE;
	static int[] order;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		command = new int[K][3];
		order = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine());
			command[k][0] = Integer.parseInt(st.nextToken()) - 1;
			command[k][1] = Integer.parseInt(st.nextToken()) - 1;
			command[k][2] = Integer.parseInt(st.nextToken());
		}

		pick(0, 0);
		System.out.println(MIN);
	}

	private static void pick(int cnt, int flag) {
		if (cnt == K) {
			int[][] next = copy(A);
			//돌리고 계산하고 되돌려놓기
			turn();
			MIN = Math.min(MIN, calc());
			A = copy(next);
		}

		for (int i = 0; i < K; i++) {
			if ((flag & 1 << i) != 0) continue;
			order[cnt] = i;
			pick(cnt + 1, flag | 1 << i);
		}
	}

	private static int calc() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < M; j++) tmp += A[i][j];
			if (min > tmp) min = tmp;
		}
		return min;
	}

	private static void turn() {
		int R, C, S, r, c, nr, nc, prev, tmp;
		for (int k = 0; k < K; k++) {//명령 수 만큼 돈다.
			R = command[order[k]][0];
			C = command[order[k]][1];
			S = command[order[k]][2];

			while (S > 0) {
				r = R - S;
				c = C - S;
				prev = A[r][c];
				for (int d = 0; d < 4; d++) {
					while ((nr = r + deltas[d][0]) >= R - S && nr <= R + S && (nc = c + deltas[d][1]) >= C - S && nc <= C + S) {
						tmp = prev;
						prev = A[nr][nc];
						A[nr][nc] = tmp;
						r = nr;
						c = nc;
					}
				}
				--S;
			}
		}
	}

	private static int[][] copy(int[][] origin) {
		int[][] next = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(origin[i],0,next[i],0,M); //origin[i].clone이랑 엄청 차이남. 메모리에서!
		}
		return next;
	}
}
