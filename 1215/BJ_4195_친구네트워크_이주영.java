package dec15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_4195_친구네트워크_이주영 {
	public static int[] parent;
	public static int[] cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<T;i++) {
			int F = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			parent = new int[F*2];
			cnt = new int[F*2];
			int idx = 0;
			Arrays.fill(cnt, 1);
			
			for(int j=0;j<F;j++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String t = st.nextToken();
				
				if(!map.containsKey(s)) {
					parent[idx] = idx;
					map.put(s, idx++);
				}
				
				if(!map.containsKey(t)) {
					parent[idx] = idx;
					map.put(t, idx++);
				}
				
				union(map.get(s), map.get(t));
				sb.append(cnt[find(map.get(t))] + "\n");
			}
		}
		System.out.println(sb);
	}

	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(find(pa) != find(pb)) {
			parent[pb] = pa;
			cnt[pa] += cnt[pb];
		}
	}
	
	public static int find(int a) {
		if(parent[a] == a)
			return a;
		
		return find(parent[a]);
	}
}
