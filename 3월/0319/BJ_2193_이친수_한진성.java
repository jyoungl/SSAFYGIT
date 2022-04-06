import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_이친수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long dp[] = new long [N+1];
		
		dp[1] = 1;
		
		if(N > 1) {
			dp[2] = 1;
		}
		
		for(int i=3;i<=N;i++) {
			
			dp[i] = dp[i-1] + dp[i-2];
			
		}

		System.out.println(dp[N]);
	}

}
