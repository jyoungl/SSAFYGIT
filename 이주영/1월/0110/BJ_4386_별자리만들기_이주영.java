package jan10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Star {
	double x;
	double y;
	
	public Star(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Cost {
	int s1;
	int s2;
	double cost;
	
	public Cost(int s1, int s2, double cost) {
		this.s1 = s1;
		this.s2 = s2;
		this.cost = cost;
	}
}

public class BJ_4386_별자리만들기_이주영 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Star> list = new ArrayList<>();
		ArrayList<Cost> cost = new ArrayList<>();
		parent = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			list.add(new Star(a,b));
			parent[i] = i;
		}
		
		for(int i=0;i<n;i++) {
			Star s = list.get(i);
			for(int j=1;j<n-1;j++) {
				Star t = list.get(j);
				double dis = Math.sqrt(Math.pow(s.x-t.x, 2) + Math.pow(s.y-t.y, 2));
				cost.add(new Cost(i,j,dis));
			}
		}
		
		cost.sort(new Comparator<Cost>() {
			@Override
			public int compare(Cost o1, Cost o2) {
				return (int)(o1.cost - o2.cost);
			}
		});
		
		double ans = 0;
		for(int i=0;i<cost.size();i++) {
			Cost c = cost.get(i);
			
			if(find(c.s1) != find(c.s2)) {
				union(c.s1, c.s2);
				ans += c.cost;
			}
		}
		
		System.out.printf("%.2f",ans);
	}
	
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[y] = x;
	}
}
