import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		
		int[] arr= new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1];		
		dp[1] = arr[1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
