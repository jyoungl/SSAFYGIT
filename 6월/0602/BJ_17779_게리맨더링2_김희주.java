import java.io.*;
import java.util.*;

public class BOJ_17779_게리맨더링2 {
	static int N;
	static int[][] A;
	static int DIFF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r < N - 1; r++) {//1<=r<=N-2
			for (int c = 2; c < N; c++) {//2<=c<=N-1
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (r + d1 + d2 > N || c - d1 < 1 || c + d2 > N) continue;
						count(r, c, d1, d2);
					}
				}
			}
		}
		System.out.println(DIFF);

	}

	public static void count(int x, int y, int d1, int d2) {
		int[] cnt = new int[5];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (r < x + d1 && c <= y && !(r >= x && c >= y - r + x)) {
					cnt[0] += A[r][c];
				} else if (r <= x + d2 && y < c && !(r >= x && c <= y + r - x)) {
					cnt[1] += A[r][c];
				} else if (x + d1 <= r && c < y - d1 + d2 && !(r <= x + d1 + d2 && c >= (y - d1 + d2 - (x + d1 + d2 - r)))) {
					cnt[2] += A[r][c];
				} else if (x + d2 < r && y - d1 + d2 <= c && !(r <= x + d1 + d2 && c <= (y - d1 + d2 + (x + d1 + d2 - r)))) {
					cnt[3] += A[r][c];
				} else {
					cnt[4] += A[r][c];
				}
			}
		}

		int min = cnt[0];
		int max = cnt[0];
		for (int i = 1; i < 5; i++) {
			if (min > cnt[i]) min = cnt[i];
			if (max < cnt[i]) max = cnt[i];
		}

		if (DIFF > max - min) DIFF = max - min;
	}

}
