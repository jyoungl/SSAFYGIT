import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교_한진성 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[][] arr = new int[N + 1][N + 1];

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] friends = new int[N*N+1][4];
		for (int i = 1; i <= N * N; i++) {

			StringTokenizer st = new StringTokenizer(in.readLine());

			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				friends[num][j] = Integer.parseInt(st.nextToken());
			}
			int x = 0;
			int y = 0;
			// 1. 비어있는 칸 중에서, 좋아하는 학생이 인접한 칸에 가장 많은 칸
			int friendCount = -1;
			int maxZero = -1;
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if(arr[j][k] != 0) {
						continue;
					}
					int temp = 0;
					int zero = 0;
					for (int d = 0; d < 4; d++) {
						int dx = j + dir[d][0];
						int dy = k + dir[d][1];
						if (dx <= 0 || dx > N || dy <= 0 || dy > N) {
							continue;
						}
						if (arr[dx][dy] == 0) {
							zero++;
						}
						for (int l = 0; l < 4; l++) {
							if (arr[dx][dy] == friends[num][l]) {
								temp++;
							}
						}
					}
					if (friendCount < temp) {
						friendCount = temp;
						x = j;
						y = k;
						maxZero = zero;
						// 2. 1이 여러개라면, 비어있는 칸이 가장 많은 칸
					} else if (friendCount == temp) {

						if (maxZero < zero) {
							x = j;
							y = k;
							maxZero = zero;
						}
					}
				}
			}
			arr[x][y] = num;
		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int count = 0;
				for (int d = 0; d < 4; d++) {
					int dx = i + dir[d][0];
					int dy = j + dir[d][1];
					if (dx <= 0 || dx > N || dy <= 0 || dy > N) {
						continue;
					}

					for (int l = 0; l < 4; l++) {
						if (arr[dx][dy] == friends[arr[i][j]][l]) {
							count++;
						}
					}
				}
				switch (count) {
				case 1:
					answer++;
					break;
				case 2:
					answer += 10;
					break;
				case 3:
					answer += 100;
					break;
				case 4:
					answer += 1000;
					break;
				}
			}
		}

		System.out.println(answer);

	}

}
