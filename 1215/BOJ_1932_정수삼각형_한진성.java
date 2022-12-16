import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형_한진성 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int arr[][] = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dp[][] = new int[N + 1][N + 1];

		dp[0][0] = arr[0][0];

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
			}
			for (int j = 0; j <= i+1; j++) {
				dp[i + 1][j] += arr[i+1][j];
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[N-1][i]);
		}
		System.out.println(answer);

	}

}
