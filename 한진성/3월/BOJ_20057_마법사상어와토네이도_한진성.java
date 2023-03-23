import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도_한진성 {

	static int[] sand = { 1, 7, 2, 10, 5, 10, 7, 2, 1, 55 };
	static int[][][] dirSand = {
			// 왼쪽 0
			{ { -1, 1 }, { -1, 0 }, { -2, 0 }, { -1, -1 }, { 0, -2 }, { 1, -1 }, { 1, 0 }, { 2, 0 }, { 1, 1 },
					{ 0, -1 } },
			// 아래 1
			{ { -1, -1 }, { 0, -1 }, { 0, -2 }, { 1, -1 }, { 2, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { -1, 1 },
					{ 1, 0 } },
			// 오른쪽 2
			{ { -1, -1 }, { -1, 0 }, { -2, 0 }, { -1, 1 }, { 0, 2 }, { 1, 1 }, { 1, 0 }, { 2, 0 }, { 1, -1 },
					{ 0, 1 } },
			// 위 3
			{ { 1, -1 }, { 0, -1 }, { 0, -2 }, { -1, -1 }, { -2, 0 }, { -1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 1 },
					{ -1, 0 } } };
	static int[][] move = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int N, arr[][];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		int startX = N / 2;
		int startY = N / 2;
		int answer = 0;
		int dir = 0;
		for (int i = 1; i < N; i++) {
			int n = 2;
			if (i == N - 1) {
				n = 3;
			}

			// 2번 또는 3번(마지막만)이동
			for (int d = 0; d < n; d++) {
				// 1부터 차근차근 커지면서 반복 (ex : 1122334455...)
				for (int j = 0; j < i; j++) {
					// 이동 및 모래 뿌리기
					startX = startX + move[dir][0];
					startY = startY + move[dir][1];
					if (arr[startX][startY] != 0) {
						int all = arr[startX][startY];
						// 위에서 설정한 비율대로 모래 흩뿌리기
						// 흩뿌리는 방식 ( 먼저 0~8번째는 비율대로 흩뿌리기. 나눠서 0되는 비율은 모래가 사라지는 게 아닌 원래 자리에 남아있는 것으로 처리
						// 9번째 - 남아있는 모래를 a 칸에 이동시키기.
						// all - 남아있는 모래.
						// 비율 검사는 전체 모래를 기준으로 해야 하기 떄문에 남아있는 모래를 분리
						for (int k = 0; k < 10; k++) {

							int dx = startX + dirSand[dir][k][0];
							int dy = startY + dirSand[dir][k][1];

							if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
								if (k == 9) {
									answer = answer + all;
								} else {
									answer = answer + (int) (arr[startX][startY] * (sand[k] / 100.0));
									all = all - (int) (arr[startX][startY] * (sand[k] / 100.0));
								}
								continue;
							}

							if (k == 9) {
								arr[dx][dy] += all;
							} else {
								arr[dx][dy] = arr[dx][dy] + (int) (arr[startX][startY] * (sand[k] / 100.0));
								all = all - (int) (arr[startX][startY] * (sand[k] / 100.0));
							}
						}
						arr[startX][startY] = 0;
//						for (int q = 0; q < N; q++) {
//							System.out.println(Arrays.toString(arr[q]));
//						}
//						System.out.println(answer);
//						System.out.println("=======================================");
					}

				}
				// 방향 전환
				dir++;
				if (dir == 4) {
					dir = 0;
				}

			}
		}
		System.out.println(answer);
	}

}
