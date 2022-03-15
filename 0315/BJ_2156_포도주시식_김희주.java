import java.io.*;

public class BOJ_2156_포도주시식 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] wine = new int[N];
		int[] dp = new int[N];

		for(int i=0;i<N;i++) wine[i] = Integer.parseInt(in.readLine());

		if(N<3){
			int result = wine[0];
			if(N==2) result += wine[1];
			System.out.println(result);
			return;
		}

		dp[0] = wine[0];
		dp[1] = dp[0]+wine[1];
		dp[2] = Math.max(Math.max(dp[0],wine[1])+wine[2],dp[1]);

		for(int i=3;i<N;i++){
			dp[i] = Math.max(dp[i-2],wine[i-1]+dp[i-3])+wine[i];
			dp[i] = Math.max(dp[i], dp[i-1]);
		}

		System.out.println(dp[N-1]);
	}
}
