import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		int[][] dp = new int[31][31];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= 30; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			for (int j = 2; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(st.nextToken());

			// nCm = N! / M! * N-M!;

			// nCr = n-1Cr-1 + n-1Cr
			System.out.println(dp[n][m]);

		}
	}

}
