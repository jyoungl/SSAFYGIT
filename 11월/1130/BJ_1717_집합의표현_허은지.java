import java.io.*;
import java.util.*;

public class G4_1717_집합의표현 {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sw = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(sw == 0) union(x, y);
			else sb.append(isSameParent(x, y)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int findParent(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}

	private static String isSameParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x==y) return "YES";
		else return "NO";
	}

	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x!=y) {
			if(x<y) parent[y] = x;
			else parent[x]=y;
		}
		
	}

}