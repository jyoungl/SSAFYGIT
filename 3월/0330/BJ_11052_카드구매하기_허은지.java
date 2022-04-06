package A형대비;

import java.io.*;
import java.util.*;

/*
 * DP
 * 무조건 비싸게(값이 크게) 구매해야 함
 * arr[i]만큼 구매한 뒤 n-i만큼 또 구매
 * DP[n] = arr[i] + DP[n-i]
 * => max값 구하기
 */
public class s1_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] DP = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int n = 1; n<=N; n++) {
			for(int i = 1; i<=n; i++) {
				DP[n] = Math.max(DP[n], arr[i] + DP[n-i]);
			}
		}
		
		System.out.println(DP[N]);

	}

}
