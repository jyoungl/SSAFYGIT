package 카탈란수;

import java.io.*;
import java.util.*;

public class s4_13699_점화식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long dp[] = new long[36];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<=35; i++) {
			for(int j = 0; j<i; j++) {
				dp[i] += (dp[j]*dp[i-j-1]);
			}
		}
		
		System.out.println(dp[n]);

	}

}
