import java.io.*;
import java.util.*;

public class BOJ_14501_퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[][] work = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {//i:시작하는날
			st = new StringTokenizer(in.readLine());
			work[i][0] = i + Integer.parseInt(st.nextToken()) - 1;//끝나는날
			work[i][1] = Integer.parseInt(st.nextToken());//가격
		}

		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1];
			for (int j = 1; j <= i; j++) {
				if (work[j][0] == i) dp[i] = Math.max(dp[i], dp[j - 1] + work[j][1]);
			}
		}

		System.out.println(dp[N]);
	}
}
