import java.io.*;
import java.util.*;

public class BJ_16926_배열돌리기1_이주영{
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N*M배열, 연산 R번 수행
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		// 배열 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// R번 회전
		for (int i = 0; i < R; i++) {
			rotate(Math.min(N / 2, M / 2));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

	// r : 사각형개수 = N/2
	static void rotate(int r) {
		// 회전
		int[][] temp = new int[N][M];
		for (int ro = 0; ro < r; ro++) {
			// 첫 행 이동
			for (int i = ro + 1; i < M - ro; i++) {
				temp[ro][i - 1] = arr[ro][i];
			}

			// 첫 열 이동
			for (int i = ro; i < N - ro - 1; i++) {
				temp[i + 1][ro] = arr[i][ro];
			}

			// 마지막 행 이동
			for (int i = ro; i < M - ro - 1; i++) {
				temp[N - ro - 1][i + 1] = arr[N - ro - 1][i];
			}

			// 마지막 열 이동
			for (int i = N - ro - 1; i > ro; i--) {
				temp[i - 1][M - ro - 1] = arr[i][M - ro - 1];
			}

		}
		arr = temp.clone();
	}

}