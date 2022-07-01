package jun23;

import java.util.Scanner;

public class BJ_9655_돌게임_이주영 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
//		int[] dp = new int[1000];
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 1;
//		
//		for(int i=4;i<=N;i++)
//			dp[i] = Math.min(dp[i-1],dp[i-3])+1; ???
//		
		if(N%2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
	
}
