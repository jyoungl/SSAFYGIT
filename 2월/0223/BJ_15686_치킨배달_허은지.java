package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. N개의 줄과 폐업시키지 않을 치킨집 M
 * 2. 도시 정보 N줄
 * 출력
 * 도시의 치킨 거리의 최솟값
 * 조건
 * 1. 1은 집, 2는 치킨 가게
 * 2. 가장 가까운 치킨 가게와의 거리가 치킨집의 개수
 * 3. 치킨집을 M개만 남겼을 때 도시의 치킨 거리가 가장 작게 되는 경우의 수 구해야 함
 * 
 * >> 순서는 상관없기 때문에 조합 사용
 */
public class BJ_15686_치킨배달_허은지 {
	
	static class Info {
		public int x, y;
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, ans;
	static int[][] arr;
	static int[] input, result;
	static ArrayList<Info> chicken = new ArrayList<>();
	static ArrayList<Info> house = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				//집의 좌표
				if(arr[i][j]==1) house.add(new Info(i, j)); 
				//치킨 가게 좌표
				else if(arr[i][j]==2) chicken.add(new Info(i, j)); 
			}
		}
		
		//치킨 가게 전체 개수
		input = new int[chicken.size()];
		//M개만 고름
		result = new int[M];
		
		for(int i = 0; i < chicken.size(); i++) {
			input[i] = i;
		}
		
		ans = Integer.MAX_VALUE;
		
		c(0,0);
		
		System.out.println(ans);
	}
	
	//조합
	private static void c(int cnt, int start) {
		//기저조건
		if(cnt == M) {
			int dSum = 0;
			for(int i = 0; i < house.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					int d = Math.abs(house.get(i).x - chicken.get(result[j]).x)
							+ Math.abs(house.get(i).y - chicken.get(result[j]).y);
					
					//각각의 치킨 거리
					distance = Math.min(distance, d);
				}
				
				//도시 치킨 거리
				dSum += distance;
			}
			
			//도시의 최소 치킨 거리
			ans = Math.min(ans, dSum);
			return;
		}
		
		//유도파트
		for(int i = start; i < chicken.size(); i++) {
			result[cnt] = input[i];
			c(cnt+1, i+1);
		}
		
	}
}
