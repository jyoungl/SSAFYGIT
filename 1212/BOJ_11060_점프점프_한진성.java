import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프_한진성 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		
		Arrays.fill(dp, 1111);
		
		dp[0] = 0;
		
		for(int i=0;i<N;i++) {
			if(dp[i] >= 1111) {
				continue;
			}
			for(int j=1;j<=arr[i];j++) {
				if(i+j >= N) {
					continue;
				}
				dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
				
			}
			
		}
		if(dp[N-1] >= 1111) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N-1]);
		}
	}

}
