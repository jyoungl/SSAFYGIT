package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_1059_좋은구간 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int[] S = new int[L];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		Arrays.sort(S);
		
		int start = 0;
		int end = 0;
		
		if(S[0]>n) end = S[0];
		else {
			for (int i = 0; i < L-1; i++) {
				if(S[i] == n || S[i+1] == n) {
					System.out.println(0);
					return;
				}
				if(S[i]<n && S[i+1]>n) {
					start = S[i];
					end = S[i+1];
				}
			}		
		}
		
//		System.out.println(start);
//		System.out.println(end);
//		System.out.println(n);
		
		int ans = n-start-1 + end-n-1 + (n-start-1)*(end-n-1);
		
		System.out.println(ans);
	}


}
