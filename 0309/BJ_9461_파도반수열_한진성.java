import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(in.readLine());
			long[] dp = new long[N + 2];

			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;

			for (int i = 3; i < N; i++) {
				dp[i] = dp[i - 2] + dp[i - 3];
			}

			System.out.println(dp[N - 1]);

		}
	}

}
