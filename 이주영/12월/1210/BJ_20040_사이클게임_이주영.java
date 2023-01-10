package dec10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20040_사이클게임_이주영 {
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		
		for(int i=0;i<n;i++)
			parent[i] = i;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(!union(x,y)) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("0");
	}

	public static int find(int a) {
		if(parent[a] == a)
			return a;
		
		return find(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x != y) {
			parent[y] = x;
			return true;
		}
		
		return false;
	}
}
