import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		// 10 -> 9 -> 3 -> 1 = 3
		// 16 -> 8 -> 4 -> 2 -> 1 = 4 ;
		// dp에 N을 나누는 최솟값을 누적시킨다.
		int[] dp = new int[N+1];
		for(int i=2;i<=N;i++) {
			// N이 3으로 나누어 떨어질 때
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i-1], dp[i/3])+1;
			}
			// N이 2로 나누어 떨어질 때
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i-1], dp[i/2])+1;
			}
			// N이 6의 배수일 때
			if(i%3 == 0 && i%2 == 0) {
				dp[i] = Math.min(dp[i/3], dp[i/2])+1;
			}
			// N이 나누어 떨어지지 않을 때
			if(i%3 != 0 && i%2 != 0 ) {
				dp[i] = dp[i-1] + 1;
			}
		}
//		System.out.println();
		System.out.println(dp[N]);
		
		
	}

}
