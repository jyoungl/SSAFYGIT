package dec16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11722_가장긴감소하는부분수열_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			A[N-i-1] = Integer.parseInt(st.nextToken());
		}
		
		int res = Integer.MIN_VALUE;
		// 10 20 20 10 30 10
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}

}
