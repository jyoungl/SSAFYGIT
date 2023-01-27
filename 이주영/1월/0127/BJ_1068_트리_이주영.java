package jan27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1068_트리_이주영 {
	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		int root = 0;
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(x == -1) {
				arr[i][i] = 1;
				root = i;
			}
			else {
				arr[x][i] = 1;
			}
		}
		
		int del = Integer.parseInt(br.readLine());
		if(del == root) {
			System.out.println(0);
			return;
		}

		for(int j=0;j<N;j++) {
			arr[del][j] = 0;
			arr[j][del] = 0;
		}
		
		dfs(root);
		System.out.println(ans);
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		boolean b = false;
		for(int i=0;i<N;i++) {
			if(arr[x][i] == 1 && !visited[i]) {
				dfs(i);
				b = true;
			}
		}
		if(!b)
			ans++;
	}
}
