import java.io.*;

public class BOJ_1699_제곱수의합 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[N+1];
		for(int i=1;i<=Math.sqrt(N);i++){
			dp[i*i] = 1;
		}
		for(int i=1;i<=N;i++){
			if(dp[i]==1) continue;
			dp[i] = dp[i-1]+1;
			for(int num=2;num<=Math.sqrt(i);num++){
				dp[i] = Math.min(dp[i], dp[i-num*num]+1);
			}
		}
		System.out.println(dp[N]);
	}
}
