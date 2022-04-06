import java.io.*;
import java.util.*;

public class BOJ_11052_카드구매하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] cards = new int[N + 1];
		for (int i = 1; i <= N; i++) cards[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = cards[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], cards[j] + dp[i - j]);
			}
		}

		System.out.println(dp[N]);
	}
}
