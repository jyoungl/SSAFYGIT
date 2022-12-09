package dec09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_여행가자_이주영 {
	public static int[] parent;
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x>y) 
			parent[b] = a;
		else if(x<y)
			parent[a] = b;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		parent = new int[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int x = Integer.parseInt(st.nextToken());
				
				if(x == 1) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		for(int i=1;i<M;i++) {
			int y = Integer.parseInt(st.nextToken());
			if(find(x) == find(y))
				x = y;
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
		
	}

}
