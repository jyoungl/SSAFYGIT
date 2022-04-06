package com.ssafy.im;

import java.util.*;

import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 숫자 n 연산의 개수 m
 * 3. m개의 줄에 각각의 연산(합집합 0 a b, 합집합인지 확인 1 a b)
 * 출력
 * 1. 1 a b에 대해서 맞으면 1 아니면 0
 * 
 * >> 0222 DisjointSetTest.java
 */
public class D4_3289_서로소집합_허은지 {
	
	static int N;
	static int[] parents;
	
	//단위집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	//a의 집합 찾기: a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]); //path compression
	}
	
	//a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D4_3289_서로소집합.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			makeSet(); // 단위 집합 만들기
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(num==0) union(from, to); 		//0이면 합집합
				else if(num==1) {					//1이면 같은 집합인지 확인
					if(findSet(from)==findSet(to)) //대표자가 같으면 같은 집합
						sb.append(1); 				//맞으면 1
					else sb.append(0); 				//아니라면 0
				}
			}
			sb.append("\n");

		}
		
		System.out.println(sb);
		
	}
	
}//class
