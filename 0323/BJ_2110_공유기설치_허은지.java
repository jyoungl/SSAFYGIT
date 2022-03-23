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
		
		//공유기 최대 간격(가장 왼쪽에 있는 집과 가장 오른쪽에 있는 집 사이 거리)
		long max = x[N-1]-x[0]+1;
		//공유기 최소 간격(바로 옆집)
		long min = 1;
		
		while(min<max) {
			//공유기 간격 구하기(이분탐색)
			long mid = (max+min)/2;
			
			int count = 1;
			
			//가장 왼쪽에 있는 집부터 설치
			long house = x[0];
			
			for(int i = 0; i<N; i++) {
				//현재 있는 집과 가장 최근에 공유기를 설치한 집의 거리가 공유기 간격보다 클 때
				if(x[i] - house >= mid) {
					//공유기 설치
					count++;
					house = x[i];
				}
			}
			
			//공유기 설치 개수가 전체 설치 개수보다 적을 때 간격을 줄인다
			if(count < C) max = mid;
			//많으면 간격을 늘린다
			else min = mid+1;
			
		}
		
		System.out.println(max-1);

	}

}
