package lv28_유니온파인드;

import java.io.*;
import java.util.*;

public class g4_1976_여행가자 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
        for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
        
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i, j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i = 1; i<M; i++) {
			isSameParent(start, Integer.parseInt(st.nextToken()));
		}

		System.out.println("YES");

	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i!=j) {
			if(i>j) parent[i] = j;
			else parent[j] = i;
		}
		
	}

	private static void isSameParent(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i!=j) {
			System.out.println("NO");
			System.exit(0);
		}
		
	}

	private static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
		
	}

}