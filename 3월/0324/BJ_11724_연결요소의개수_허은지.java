package A형대비;

import java.io.*;
import java.util.*;

public class s2_11724_연결요소의개수 {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		checked = new boolean[N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u-1][v-1] = arr[v-1][u-1] = 1;
		}
		
		for(int i = 0; i<N; i++) {
			if(!checked[i]) {
				dfs(i);
				ans++;
			}
		}
		
		
		System.out.println(ans);

	}

	private static void dfs(int start) {
		for(int i = 0; i<N; i++) {
			checked[start] = true;
			if(!checked[i] && arr[start][i] == 1) dfs(i);
		}
	}
}
