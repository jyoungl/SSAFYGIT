package 카탈란수;

import java.io.*;
import java.util.*;

public class G3_1670_정상회담2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[10001];
		
		dp[0] = 1;
		dp[2] = 1;
		
		for(int i = 2; i <= 5000; i++) {
			for(int j = 0; j < i; j++) {
				dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
				dp[i*2] %= 987654321;
			}
		}

		int N = Integer.parseInt(br.readLine());
		sb.append(dp[N]).append("\n");
		
		System.out.println(sb);

	}

}
