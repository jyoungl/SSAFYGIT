import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		
		int dp[] = new int[N];
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		dp[0] = 1;
		dp[1] = 2;
		
		
		for(int i=2;i<N;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[N-1]);
		
	}

}
