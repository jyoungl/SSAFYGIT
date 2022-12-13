import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398_연속합2_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		int[][] dp = new int[N][2];
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		int answer = arr[0];
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
			
			answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(answer);
		
	}
}