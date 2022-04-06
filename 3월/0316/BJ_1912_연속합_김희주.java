import java.io.*;
import java.util.*;

public class BOJ_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		dp[0] = A[0];

		int max = dp[0];
		for(int i=1;i<N;i++){
			dp[i] = Math.max(dp[i-1]+A[i], A[i]);
			max = Math.max(dp[i],max);
		}

		System.out.println(max);
	}
}
