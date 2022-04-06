import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N+1]; 
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		int[] dp = new int[N+1];
		
		dp[1] = arr[1];
		if(N >= 2) {
			dp[2] = arr[2] + arr[1];
		}
		for(int i=3;i<=N;i++) {
			// 각 칸별로 누적되는 계단의 점수중 최댓값.
			// N번째 포도주를 먹는다고 할 때 가능한 경우의 수
			// 1. N, N-1 번째 포도주를 먹는다.
			// 2. N, N-2 번째 포도주를 먹는다.
			// N번째 포도주를 먹지 않는 경우도 있다.
			// 3. N-1, N-2번째 포도주를 먹는다.
			
			//  N-1번째 포도주와 dp의 N-3번에 누적된 값
			//  N번째 포도주와 dp의 N-2번에 누적된 값 중 최댓값을 골라 N번 째 dp 배열에 값을 넣을 수 있다.
			//  현재 포도주를 먹지 않는 경우의 수도 있는데 이 부분은 내 바로 이전 값과 최댓값비교로 얻을 수 있다.
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}

}
