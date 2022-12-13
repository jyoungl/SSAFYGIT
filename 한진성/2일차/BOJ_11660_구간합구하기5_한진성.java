import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N+1][N+1];
		int dp[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j > 0) {
					dp[i][j] = dp[i][j-1] + arr[i][j];
				}else {
					dp[i][j] = arr[i][j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for(int j=a1; j<=b1; j++) {
				sum = sum + (dp[j][b2] - dp[j][a2-1]);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
