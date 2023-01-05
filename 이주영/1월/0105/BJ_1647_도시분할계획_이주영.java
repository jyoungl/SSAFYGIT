package jan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Route {
	int s;
	int e;
	int cost;
	
	public Route(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}

public class BJ_1647_도시분할계획_이주영 {
	public static int N, M;
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Route> list = new ArrayList<>();
		parent = new int[N+1];
		for(int i=1;i<=N;i++)
			parent[i] = i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Route(x,y,z));
		}
		
		list.sort(new Comparator<Route>() {
			@Override
			public int compare(Route o1, Route o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		int ans = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<list.size();i++) {
			Route r = list.get(i);
			
			if(find(r.s) != find(r.e)) {
				union(r.s, r.e);
				ans += r.cost;
				max = (max>r.cost ? max : r.cost);

			}
		}
		
		System.out.println(ans - max);
	}
	
	public static int find(int a) {
		if(parent[a] == a)
			return a;
		
		return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = parent[a];
		b = parent[b];
		
		if(a != b)
			parent[a] = b;
	}

}
