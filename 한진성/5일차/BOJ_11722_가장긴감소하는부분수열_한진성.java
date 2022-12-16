import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			
			for(int j=0;j<N;j++) {
				if(arr[i] < arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
				
			}
			
		}
		
		int max = 0;
		
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}

}
