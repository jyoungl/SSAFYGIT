package jan11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9657_돌게임_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
/*		//상근 true, 창영 false
		boolean[] dp = new boolean[1001];
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		dp[4] = true;
		
		for(int i=5;i<=N;i++) {
			if(i%7==0 || i%7 == 2)
				dp[i] = false;
			else
				dp[i] = true;
		}
		
		if(dp[N] == true)
			System.out.println("SK");
		else
			System.out.println("CY");*/
		if(N%7 == 0 || N%7 == 2)
			System.out.println("CY");
		else
			System.out.println("SK");
	}

}
