package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart {
	static int arr[], ans[];
	static int limit;
	static int N;
	static int weight;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_9229.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine()," ");
			arr = new int[N];
			ans = new int[2];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			weight = 0;
			combination(0,0);
			if(weight == 0) {
				weight = -1;
			}
			sb.append("#").append(tc).append(" ").append(weight).append("\n");
		}
		System.out.print(sb);
	}

	public static void combination(int cnt, int start) {
		int inweight;
		if(cnt == 2) {
			inweight = ans[0] + ans[1];
			if(inweight <= limit) {
				weight = Math.max(weight, inweight);
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			ans[cnt] = arr[i];
			combination(cnt+1, i+1); // 다음 자리는 현재 뽑은 i의 다음 수부터 시작하도록 전달
		}
	}
	
}
