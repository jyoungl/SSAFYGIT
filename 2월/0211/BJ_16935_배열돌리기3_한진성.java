package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for (int r = 0; r < R; r++) {
			N = arr.length;
			M = arr[0].length;
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				for (int i = 0; i < N / 2; i++) {
					int[] tempArr1 = Arrays.copyOf(arr[i], M);
					arr[i] = Arrays.copyOf(arr[N - 1 - i], M);
					arr[N - 1 - i] = Arrays.copyOf(tempArr1, M);
				}
				break;
			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][M - j - 1];
						arr[i][M - j - 1] = temp;
					}
				}
				break;
			case 3:
				int[][] tmpArr2 = new int[M][N];
				for (int j = 0; j < M; j++) {
					for (int i = 0; i < N; i++) {
						tmpArr2[j][i] = arr[N - i - 1][j];
					}
				}
				arr = tmpArr2;
				break;
			case 4:
				int[][] tmpArr3 = new int[M][N];
				for (int j = 0; j < M; j++) {
					for (int i = 0; i < N; i++) {
						tmpArr3[M - j - 1][i] = arr[i][j];
					}
				}
				arr = tmpArr3;
				break;
			case 5:
				// 왼쪽 위
				int[][] tmpArr4 = new int[N / 2][M / 2];
				// 오른쪽 위
				int[][] tmpArr5 = new int[N / 2][M / 2];
				// 왼쪽 아래
				int[][] tmpArr6 = new int[N / 2][M / 2];
				// 오른쪽 아래
				int[][] tmpArr7 = new int[N / 2][M / 2];
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmpArr4[i][j] = arr[i][j];
						tmpArr5[i][j] = arr[i][j + M / 2];
						tmpArr6[i][j] = arr[i + N / 2][j];
						tmpArr7[i][j] = arr[i + N / 2][j + M / 2];
					}
				}

				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						arr[i][j] = tmpArr6[i][j];
						arr[i][j + M / 2] = tmpArr4[i][j];
						arr[i + N / 2][j] = tmpArr7[i][j];
						arr[i + N / 2][j + M / 2] = tmpArr5[i][j];
					}
				}
				break;
			case 6:
				// 왼쪽 위
				int[][] tmpArr8 = new int[N / 2][M / 2];
				// 오른쪽 위
				int[][] tmpArr9 = new int[N / 2][M / 2];
				// 왼쪽 아래
				int[][] tmpArr10 = new int[N / 2][M / 2];
				// 오른쪽 아래
				int[][] tmpArr11 = new int[N / 2][M / 2];
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmpArr8[i][j] = arr[i][j];
						tmpArr9[i][j] = arr[i][j + M / 2];
						tmpArr10[i][j] = arr[i + N / 2][j];
						tmpArr11[i][j] = arr[i + N / 2][j + M / 2];
					}
				}

				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						arr[i][j] = tmpArr9[i][j];
						arr[i][j + M / 2] = tmpArr11[i][j];
						arr[i + N / 2][j] = tmpArr8[i][j];
						arr[i + N / 2][j + M / 2] = tmpArr10[i][j];
					}
				}
				break;

			}
		}
		arrprint(arr);
	}

	static void arrprint(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
