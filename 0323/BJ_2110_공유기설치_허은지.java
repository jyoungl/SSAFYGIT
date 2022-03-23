package lv21_이분탐색;

import java.io.*;
import java.util.*;

/*
 * 전체 거리(max)를 반으로 나눠서 개수를 따진다
 */
public class g5_2110_공유기설치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long[] x = new long[N];
		
		
		for(int i = 0; i<N; i++) {
			x[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(x);
		
		long max = x[N-1]-x[0]+1;
		long min = 1;
		
		while(min<max) {
			long mid = (max+min)/2;
			
			int count = 1;
			long house = x[0];
			
			for(int i = 0; i<N; i++) {
				if(x[i] - house >= mid) {
					count++;
					house = x[i];
				}
			}
			
			if(count < C) max = mid;
			else min = mid+1;
			
		}
		
		System.out.println(max-1);

	}

}
