import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st;
		int[][] arr = new int[N + 2][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 2];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N+1; i++) {
			max = Math.max(dp[i], max);

			if (i + arr[i][0] < N + 2) {
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
			}
		}
		System.out.println(max);
	}
}
