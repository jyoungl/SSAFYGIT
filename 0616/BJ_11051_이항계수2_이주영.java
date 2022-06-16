package jun16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_이항계수2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][N+1];
		dp[1][1] = 1;
		dp[1][0] = 1;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j || j==0) 
					dp[i][j] = 1;			
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
