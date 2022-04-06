package mar31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717_집합의표현_이주영 {
	static int[] parents;
	
	public static int find(int c) {
		if(parents[c] == c)
			return c;
		return find(parents[c]);
	}
	
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x>y)
			parents[y] = x;
		else if(x<y)
			parents[x] = y;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i=0;i<=N;i++)
			parents[i] = i;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 1) {
				if(find(a) == find(b))
					sb.append("YES"+"\n");
				else
					sb.append("NO"+"\n");
			}
			else {
				union(a,b);
			}
		}
		
		System.out.println(sb);
	}
}
