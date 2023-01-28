package jan28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_16398_행성연결_이주영 {
	public static class Planet {
		int x;
		int y;
		int cost;
		
		public Planet(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static int N;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parent = new int[N];
		ArrayList<Planet> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c != 0)
					list.add(new Planet(i,j,c));
			}
		}
		
		for(int i=0;i<N;i++)
			parent[i] = i;
		
		list.sort(new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.cost - o2.cost;
			}
		});
		
		long ans = 0;
		int cnt = 0;
		for(int i=0;i<list.size();i++) {
			if(cnt == N-1)
				break;
			Planet p = list.get(i);
//			int a = find(p.x);
//			int b = find(p.y);
			if(!sameParent(p.x, p.y)) {
				union(p.x, p.y);
				ans += p.cost;
				cnt++;
			}
		}
		
		System.out.println(ans);
	}

	public static boolean sameParent(int x, int y) {
		return find(x) == find(y);
	}
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[y] = x;
	}
}
