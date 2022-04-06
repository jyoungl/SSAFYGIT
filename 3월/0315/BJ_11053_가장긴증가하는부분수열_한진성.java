import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//1번부터 i번째 수까지 있을 때 i를 맨 마지막 원소로 삼는 최장 증가 부분 수열의 길이
		int dp[] = new int[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			dp[i] =1;
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
	}

}
