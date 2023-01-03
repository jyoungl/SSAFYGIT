package jan03;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_15663_N과M9_이주영 {
	static ArrayList<Integer> arr;
	static HashSet<String> ans;
	static boolean[] visited;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		ans = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		visited = new boolean[arr.size()];
		dfs(0, "");
		System.out.println(sb);
		
	}

	public static void dfs(int cnt, String now) {
		if(cnt == M) {
			if(!ans.contains(now)) {
				sb.append(now).append("\n");
				ans.add(now);
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			int x = arr.get(i);
			dfs(cnt+1, now+String.valueOf(x)+" ");
			visited[i] = false;
		}
	}
}
