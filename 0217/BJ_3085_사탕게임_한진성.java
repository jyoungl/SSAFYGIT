import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3085_사탕게임 {

	static char[][] arr;
	static int max;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					continue;
				}
				char temp = arr[i][j];
				arr[i][j] = arr[i][j + 1];
				arr[i][j + 1] = temp;

				mapCheck();
				
				temp = arr[i][j];
				arr[i][j] = arr[i][j + 1];
				arr[i][j + 1] = temp;

			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) {
					continue;
				}
				char temp = arr[i][j];
				arr[i][j] = arr[i + 1][j];
				arr[i + 1][j] = temp;

				mapCheck();

				temp = arr[i][j];
				arr[i][j] = arr[i + 1][j];
				arr[i + 1][j] = temp;

			}
		}
		System.out.println(max);
	}

	public static void mapCheck() {
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
		max = Math.max(max, cnt);

		for (int j = 0; j < N; j++) {
			cnt = 1;
			for (int i = 0; i < N - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) {
					cnt++;

				} else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
		max = Math.max(cnt, max);

	}
}
