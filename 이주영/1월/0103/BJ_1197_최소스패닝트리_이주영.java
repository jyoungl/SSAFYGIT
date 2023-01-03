package jan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
	int s, e, cost;
	
	public Edge(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}

public class BJ_1197_최소스패닝트리_이주영 {
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Edge> edge = new ArrayList<>();
		parent = new int[V+1];
		int ans = 0;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			edge.add(new Edge(x, y, z));
		}
		
		edge.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<edge.size();i++) {
			Edge e = edge.get(i);
			
			if(find(e.s) != find(e.e)) {
				union(e.s, e.e);
				ans += e.cost;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b)
			parent[a] = b;
	}
}
