import java.io.*;
import java.util.*;

public class BOJ_13398_연속합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[][] dp = new int[N+1][2];
		int max = dp[1][0] = dp[1][1] = Integer.parseInt(st.nextToken());
		for(int i=2;i<=N;i++){
			int num = Integer.parseInt(st.nextToken());
			dp[i][0] = dp[i-1][0] < 0 ? num : dp[i-1][0]+num;
			dp[i][1] = Math.max(dp[i-2][0], dp[i-1][1])+num;
			max = Math.max(max, Math.max(dp[i][0],dp[i][1]));
		}
		System.out.println(max);
	}
}
