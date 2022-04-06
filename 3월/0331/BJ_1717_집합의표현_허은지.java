package lv28_유니온파인드;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. n m
 * 2. m개의 줄에 각각의 연산 주어짐
 * 출력
 * 1. 1로 시작하는 입력에 대해서 YES/NO로 결과 출력
 * 조건
 * 1. 합집합은 0 a b
 * 2. 같은 집합에 포함되어 있는지를 확인 1 a b
 * 
 * 유니온 파인드
 * >> 부모가 같은지 확인한다
 * >> 재귀 이용
 */
public class g4_1717_집합의표현 {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sw = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(sw == 0) union(x, y);
			else sb.append(isSameParent(x, y)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int findParent(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}

	private static String isSameParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x==y) return "YES";
		else return "NO";
	}

	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x!=y) {
			if(x<y) parent[y] = x;
			else parent[x]=y;
		}
		
	}

}
