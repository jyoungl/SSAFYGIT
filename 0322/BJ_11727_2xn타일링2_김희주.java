import java.io.*;

public class BOJ_11727_2xn타일링2 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int DIV = 10007;

		int[] dp = new int[1000];
		dp[0] = 1;
		dp[1] = 3;

		for(int i=2;i<N;i++) dp[i] = (dp[i-1]+(dp[i-2]*2)%DIV)%DIV;

		System.out.println(dp[N-1]);
	}
}
