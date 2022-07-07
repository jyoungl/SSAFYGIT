package jul07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10819_차이를최대로_이주영 {
	static int N, res = Integer.MIN_VALUE;
	static int[] arr;
	static boolean[] visited;
	public static void dfs(int cnt, int a, int sum) {
		if(cnt == N) {
			res = Math.max(res, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			dfs(cnt+1, arr[i], cnt==0?0:sum+Math.abs(arr[i]-a));
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		dfs(0,0,0);
		
		System.out.println(res);
	}

}
