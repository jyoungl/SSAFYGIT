import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	

		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[N];
		
		dp[0] = arr[0];
		int ans = dp[0];
		for(int i=1;i<N;i++) {
			// dp 조건
		    // 지금까지의 최댓값이 현재 값보다 작으면 현재 값으로 덮어씌운다.
            // 10 -4 3 1 5 6 -35 12 21 -1
            // 10 6 9 10 15 21 -14 12 33 -1
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			
			if(ans < dp[i]) {
				ans = dp[i];
			}
		}
		
		System.out.println(ans);
		
		
		
		
	}

}
