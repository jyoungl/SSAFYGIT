import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int[] dp = new int[N+1];
		
		// 각 칸별로 누적되는 계단의 점수중 최댓값.
		// 
		// 
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0],0)+arr[1];
		if(N > 1) {
			dp[2] = Math.max(arr[1], dp[0])+arr[2];
		}
		for(int i=3;i<N;i++) {
			dp[i] = Math.max(arr[i-1]+dp[i-3], dp[i-2])+arr[i];
		}
		System.out.println(dp[N-1]);
	}
	
}
