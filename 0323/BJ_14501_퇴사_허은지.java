package A형대비;

import java.io.*;
import java.util.*;

public class s3_14501_퇴사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[21][2];
		int[] DP = new int[21];
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int i = 1; i<=N+1; i++) {
			int day = i+arr[i][0];
			DP[i] = Math.max(DP[i], max);
			DP[day] = Math.max(DP[day], DP[i] + arr[i][1]);
			max = Math.max(DP[i], max);
		}
		
		System.out.println(max);
	}

}
