import java.io.*;

public class BOJ_1309_동물원 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int div = 9901;

		int[][] dp = new int[N+1][2]; //0번째 칸 : 01,10, 1번째 칸:00
		dp[1][0] = 1;
		dp[1][1] = 1;

		for(int i=2;i<=N;i++){
			dp[i][0] = (dp[i-1][0]+dp[i-1][1])%div;
			dp[i][1] = (dp[i][0]+dp[i-1][0])%div;
		}

		System.out.println((dp[N][0]*2+dp[N][1])%div);
	}

}
