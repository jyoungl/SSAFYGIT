package com.ssafy;

import java.io.*;
import java.util.*;

// union-find
/** <정리>
- 각 노드마다 부모가 어떤 노드인지 설정해 주는 것
- 처음에 parent 배열은 parent[i] = i 형태로 자기자신을 가리키고 있음
- https://brenden.tistory.com/33 : 유니온파인드 정리 잘되어있음
 */
public class BJ_1717_집합의표현 {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 7 8
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1]; // 원소를 {0}부터 가지기 때문에 N+1이 배열의 크기이다
		for (int i = 0; i <= N; i++) {
			parent[i] = i; // 자기자신을 가리키고 있음
		}
		
		/*
		 0 1 3
		 1 1 7
		 0 7 6
		 1 7 1
		 0 3 7
		 0 4 2
		 0 1 1
		 1 1 1
		 */
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) { // M번의 연산
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) { // 합집합 연산(0)이면 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다
				union(a, b); // 부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합칩
			} else { // command == 1이면 두 원소가 같은 집합에 있는지 확인한다
				sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
			}
		}
		
		System.out.println(sb);
	}

	// x의 부모를 찾아보자
	private static int find(int x) {
		if(x == parent[x]) { // parent[i] = i 형태로 자기자신을 가리키고 있음
			return x;
		}
		
		// 그렇지 않다면,x와 연결된 parent[x]의 parent를 찾으러 간다. 타고 올라가다 보면 결국 x의 최종 부모를 찾게 됨
		return parent[x] = find(parent[x]);
	}
	
	
	private static void union(int x, int y) {
		x = find(x); // x의 최종 부모를 찾는다
		y = find(y); // y의 최종 부모를 찾는다
		
		if(x != y) { // x와 y의 부모가 같지 않다면
			if(x < y) {
				parent[y] = x; // 부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합칩
			} else { // (x > y)
				parent[x] = y;
			}
		}
		
	}

	// x와 y의 부모가 같은지 알아보자
	private static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return true;
		return false;
	}
}
