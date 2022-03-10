import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이 문제 다시보기
public class BOJ_1149_RGB거리 {
	static int[][] dp;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
	 /*
	     dp[i][0] = Min(d[i-1][1], d[i-1][2]) + a[i][0];
	     dp[i][1] = Min(d[i-1][0], d[i-1][2]) + a[i][1];
	     dp[i][2] = Min(d[i-1][0], d[i-1][1]) + a[i][2];
	 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		
		arr = new int[N][3];
		dp = new int[N][3];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		System.out.print(Math.min(Paint_cost(N-1,0),Math.min(Paint_cost(N-1,1),Paint_cost(N-1,2))));
		
	}
	
	static int Paint_cost(int N, int color) {
		if(dp[N][color] == 0) {
			
			if(color == 0) {
				dp[N][0] = Math.min(Paint_cost(N-1,1), Paint_cost(N-1,2))+arr[N][0];
			}else if(color == 1){
				dp[N][1] = Math.min(Paint_cost(N-1,0), Paint_cost(N-1,2))+arr[N][1];
			}else if(color == 2) {
				dp[N][2] = Math.min(Paint_cost(N-1,0), Paint_cost(N-1,1))+arr[N][2];
			}
			
		}
		return dp[N][color];
	}
}
