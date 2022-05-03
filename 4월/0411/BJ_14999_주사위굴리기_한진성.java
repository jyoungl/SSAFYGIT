import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14999_주사위굴리기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dir = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		Map<Integer, Integer> dice = new HashMap<>();
		
		for (int i = 1; i <= 6; i++) {
			dice.put(i, 0);
		}


		
		// 윗면 1, 아랫면 6, 오른쪽 3, 왼쪽 4, 위쪽 2, 아래쪽 5
		st = new StringTokenizer(in.readLine(), " ");
		
		// 위 기준으로 동, 서, 남, 북
		int top = 1;
		int base = 6;
		int east = 3;
		int west = 4;
		int north = 5;
		int south = 2;

		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(st.nextToken());
			int dx = X + dir[C][0];
			int dy = Y + dir[C][1];
			if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
				continue;
			}
			int temp = 0;
			switch (C) {
			// 동쪽으로 굴렀을 때
			case 1:
				// 천장 임시저장
				temp = top;

				// 서 -> 천장
				top = west;

				// 바닥 -> 서
				west = base;

				// 동 -> 바닥
				base = east;

				// 천장 -> 동
				east = temp;
				break;
			// 서쪽으로 굴렀을 때
			case 2:
				temp = top;
				top = east;
				east = base;
				base = west;
				west = temp;
				break;
			// 북쪽으로 굴렀을 때
			case 3:
				temp = top;
				top = south;
				south = base;
				base = north;
				north = temp;
				break;
			// 남쪽으로 굴렀을 때
			case 4:
				temp = top;
				top = north;
				north = base;
				base = south;
				south = temp;
				break;
			}
//			System.out.printf("%d %d %d %d %d %d\n", top, east, base, west, north, south);
			System.out.println(dice.get(top));
			if (arr[dx][dy] != 0) {
				dice.replace(base, arr[dx][dy]);
				arr[dx][dy] = 0;
			} else {
				arr[dx][dy] = dice.get(base);
			}
			X = dx;
			Y = dy;
		}
	}

}
