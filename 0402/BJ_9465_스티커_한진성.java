import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			StringTokenizer st;
			
			int[][] arr = new int[2][N];
			for(int i=0;i<2;i++) {
				 st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[3][N];
			
			dp[0][0] = 0;
			dp[1][0] = arr[0][0];
			dp[2][0] = arr[1][0];
			
			for(int i=1;i<N;i++) {
				// 아무것도 안떼는경우
				dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
				// 위의 스티커를 떼는 경우
				dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1])+ arr[0][i];
				// 아래 스티커를 떼는 경우
				dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1])+arr[1][i];
			}
			
			System.out.println(Math.max(dp[0][N-1], Math.max(dp[1][N-1], dp[2][N-1])));
		}
	}

}
