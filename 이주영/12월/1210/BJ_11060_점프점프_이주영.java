package dec10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11060_점프점프_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for(int i=1;i<N;i++) {
			for(int j=i;j<i+arr[i-1]&&j<N;j++) {
				if(dp[j] == Integer.MAX_VALUE && dp[j-1] == Integer.MAX_VALUE) {
					System.out.println("-1");
					return;
				}
				dp[j] = Math.min(dp[j], dp[i-1] + 1);
			}
		}
		
		System.out.println(dp[N-1]);

	}

}
