import java.io.*;
import java.util.*;

public class BOJ_11055_가장큰증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N][2];
		dp[0][0] = 0;
		dp[0][1] = A[0];
		for(int i=1;i<N;i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			int max = 0;
			for(int j=0;j<i;j++){
				if(A[j]<A[i]) max = Math.max(max,dp[j][1]);
			}
			dp[i][1] = max+A[i];
		}

		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}
}

