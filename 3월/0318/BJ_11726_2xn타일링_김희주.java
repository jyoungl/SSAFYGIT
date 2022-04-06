import java.io.*;

public class BOJ_11726_2xn타일링 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[N+1];
		int DIV = 10007;

		if(N<3){
			System.out.println(N);
			return;
		}

		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) dp[i] = (dp[i-1]+dp[i-2])%DIV;

		System.out.println(dp[N]);
	}
}
