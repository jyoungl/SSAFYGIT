package jan30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11048_이동하기_이주영 {
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				for(int d=0;d<3;d++) {
//					int dx = i + dr[d];
//					int dy = j + dc[d];
//					if(dx<0||dy<0||dx>=N||dy>=M)
//						continue;
//					dp[dx][dy] = Math.max(dp[dx][dy], dp[i][j] + arr[dx][dy]);
//					//dp[dx][dy] = Math.max(dp[i][j] + arr[dx][dy], Math.max(dp[dx][dy], arr[i][j] + arr[dx][dy]));
//					//System.out.println(dx + " " + dy + " : " + dp[dx][dy]);
//				}
//			}
//		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i][j-1] + arr[i][j]);
			}
		}
		System.out.println(dp[N][M]);
	}

}
