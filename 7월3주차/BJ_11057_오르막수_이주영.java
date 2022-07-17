package jul17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057_오르막수_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][10];
		long[] res = new long[N+1];
		
		for(int i=0;i<10;i++)
			dp[1][i] = 1;
		
		res[1] = 10;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j==0)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
					dp[i][j] %= 10007;
				}
				res[i] += dp[i][j];
			}
		}
		
		System.out.println(res[N] % 10007);
	}

}
