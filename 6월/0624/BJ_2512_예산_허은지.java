package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_2512_예산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] budget = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(budget);
		
		long min = 0;
		long mid = 0;
		long max = budget[N-1];

		while(min<=max) {
			mid = (max+min)/2;
			long money = 0;

			for(int i = 0; i<N; i++) {
				if(budget[i] - mid >= 0) money += mid;
				else money += budget[i];
			}
			
			if(money<=M) min = mid+1;
			else max = mid-1;
		}
		
		System.out.println(max);
		


	}

}
