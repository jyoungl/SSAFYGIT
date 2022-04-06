import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수 {

	
	static final int num = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 1. 마지막 숫자가 0일 경우 이전 자리에는 무조건 1만 온다.
		 * 2. 마지막 숫자가 9 일 경우 이전 자리에는 무조건 8만 온다
		 * 3. 마지막 숫자가 나머지일 경우 이전 자리에는 무조건 앞자리 수의 -1 또는 +1만 온다.
		 */
		
		int N = Integer.parseInt(in.readLine());
		// 1~100 까지 자릿수를 저장할 배열
		int[][] dp = new int[101][10];
		
		//1자리일 때는 개수가 1개이고, 앞자리에는 0부터 시작할 수 없기 때문에 0은 빼고 1을 넣는다
		for(int i=1;i<=9;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				// 0일 경우 1
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1] % num;
				// 9일경우 8
				}else if(j == 9) {
					dp[i][j] = dp[i-1][j-1] % num;
				// 1~8일 경우 -1과 +1
				}else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % num;
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0;i<=9;i++) {
			answer = (answer + dp[N][i])%num;
		}
		
		System.out.println(answer);
		
	}

}
