import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {

	static int[] dp = new int[41];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		dp[0] = 0;
		dp[1] = 1;

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(in.readLine());

			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			if (N == 0) {
				System.out.println(1 + " " + 0);
			} else {
				System.out.println(dp[N - 1] + " " + dp[N]);
			}
		}

	}

}
