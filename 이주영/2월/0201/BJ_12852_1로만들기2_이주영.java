package feb01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12852_1로만들기2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] dp = new String[N+1];
		dp[1] = "0";
		
		for(int i=2;i<=N;i++) {
			int x = i;
			dp[i] = "";
			if(x%3 == 0) {
				if(dp[x/3].length()<dp[x-1].length()) {
					dp[i] += "3";
					dp[i] += dp[x/3];
				}
				else
					dp[i] = "1" + dp[x-1];
			}
			else if(x%2 == 0) {
				if(dp[x/2].length()<dp[x-1].length()) {
					dp[i] += "2";
					dp[i] += dp[x/2];
				}
				else
					dp[i] = "1" + dp[x-1];
			}
			else
				dp[i] = "1" + dp[x-1];
			
			if(x%6 == 0) {
				String s ="";
				if(dp[x/3].length()>dp[x/2].length())
					s = "2" + dp[x/2];
				else if(dp[x/3].length()<=dp[x/2].length())
					s = "3" + dp[x/3];
				
				if(s.length()<dp[i].length())
					dp[i] = s;
			}
		}
		
		char[] ans = dp[N].toCharArray();
		sb.append(ans.length-1).append("\n").append(N).append(" ");
		for(int i=0;i<ans.length-1;i++){
			int op = ans[i] - '0';
			
			if(op == 1)
				sb.append(--N).append(" ");
			else {
				sb.append(N/op).append(" ");
				N /= op;
			}
		}
		System.out.println(sb);
	}

}
