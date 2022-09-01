package jul17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11055_가장큰증가부분수열_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[0] = arr[0];
		
		for(int i=1;i<N;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[i] < dp[j] + arr[i])
					dp[i] = dp[j]+arr[i];
			}
		}
		
		int res = Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
			res = Math.max(dp[i], res);
		
		System.out.println(res);
	}

}
