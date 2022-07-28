package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1965_상자넣기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int DP[] = new int[N];
		for (int i = 0; i < N; i++) {
			DP[i] = 1;
		}
		
		int ans = 0;
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) DP[i] = Math.max(DP[i], DP[j]+1); 
			}
			
			ans = Math.max(DP[i], ans);
		}
		
		System.out.println(ans);

	}

}
