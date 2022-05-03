package lv28_유니온파인드;

import java.io.*;
import java.util.*;

public class g4_20040_사이클게임 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		
		// 0부터 해야 함
        for(int i = 0; i<n; i++) {
			parent[i] = i;
		}
        
		for(int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(union(n1, n2)) {
				System.out.println(i);
				System.exit(0);
			}
		}
		
		System.out.println(0);

	}

	private static boolean union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i!=j) {
			// 점에서 한 번만 선이 나와야 하므로 부모 생각 안하고 그냥 잇기
			parent[i] = j;
			return false;
		}
		
		return true;
		
	}

	private static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
		
	}

}
