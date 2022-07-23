import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1965_상자넣기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int dp[] = new int[N];
		for(int i=0;i<N;i++) {
			dp[i] = 1;
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[j] < arr[i]) {
					
					dp[i] = Math.max(dp[j]+1, dp[i]);
					
				}
				
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}
