package jan31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057_오르막수_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10];
		long[] res = new long[N+1];
		
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
	
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][0] % 10007); 
	}

}
