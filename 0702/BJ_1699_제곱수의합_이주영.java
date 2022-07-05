package jul02;

import java.util.Scanner;

public class BJ_1699_제곱수의합_이주영 {

	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		for(int i=2;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j=1;j<=i/2;j++) {
				if(j*j == i) {
					min = 1;
					break;
				}
				else {
					min = Math.min(min, dp[j]+dp[i-j]);
				}
			}
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}

}
