import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2xN타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int dp[] = new int[N];

		if (N == 1) {
			System.out.println(1);
			return;
		}

		dp[0] = 1;
		dp[1] = 3;
		
		for(int i=2;i<N;i++) {
//			if(i%2 == 0) {
//				dp[i] = dp[i-1] + dp[i-2]*2;
//			}else {
//				dp[i] = dp[i-1]*2 + dp[i-2];
//			}
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}

		System.out.println(dp[N-1]);
	}

}
