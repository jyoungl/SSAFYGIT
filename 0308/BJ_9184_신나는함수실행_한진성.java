import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_신나는함수실행 {

	static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		dp = new int[21][21][21];
		while(true) {
			st = new StringTokenizer(in.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(a==-1&&b==-1&&c==-1) {
				break;
			}
			long n = w(a,b,c);
			
			sb.append(String.format("w(%d, %d, %d) = %d\n",a,b,c, n));
		}
		System.out.print(sb);
	}
	
	public static int w(int a, int b, int c) {
		
		if((a>=0 && a <=20 && b >= 0 && b <= 20 && c >= 0 && c <= 20) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			dp[20][20][20] = w(20,20,20);
			return dp[20][20][20];
		}
		
		if(a < b && b < c) {
			dp[a][b][c] =w(a,b,c-1)+w(a,b-1,c-1) - w(a,b-1,c);
			return dp[a][b][c];
		}
		dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		return dp[a][b][c];
		
	}
	
}
