import java.io.*;
import java.util.*;

public class S2_11053_가장긴증가하는부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        int max = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);		// 수열은 1개부터 시작되기 때문에 dp 배열을 1로 초기화해준다
        
        for (int i = 0; i < N-1; i++) {
			int num = arr[i];							// 비교할 숫자
			for (int j = i+1; j < N; j++) {
				if(arr[j]>num) {						// 비교할 숫자보다 더 큰 수가 나온다면(증가하는 수열 조건을 만족한다면)
					dp[j] = Math.max(dp[i]+1, dp[j]);	// 현재 수열 길이(DP[i]+1)와 예전에 저장해 둔 수열 길이(DP[i+j]) 중 큰 것을 저장
					max = Math.max(max, dp[j]);			// 수열 길이 max값 구하기
				}
			}
		}
        
        System.out.println(max);
    }

}
