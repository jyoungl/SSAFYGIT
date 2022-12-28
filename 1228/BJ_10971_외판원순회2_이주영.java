package dec28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2_이주영 {
	static int N;
	static int[][] arr;
	static int[] ans;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		ans = new int[N];
		visited = new boolean[N+1];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			visited[i+1] = true;
			dfs(i,i,0,0);
			visited[i+1] = false;
		}
		
		System.out.println(min);
	}
	
	public static void dfs(int s, int n, int sum, int cnt) {
		if(cnt == N-1) {
			//다시 원래도시로 돌아와야 하기 때문에 마지막 횟수는 원래 도시로 돌아가는 데 써야함
			if(arr[n][s] != 0) {
				sum += arr[n][s];
				if(sum < min)
					min = sum;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			//가려고 하는 도시 i를 방문했는지, 현재 있는 도시 n과 동일한 곳인지 체크
			if(!visited[i+1] && arr[n][i]!= 0) {
				visited[i+1] = true;
				dfs(s, i, sum+arr[n][i], cnt+1);
				visited[i+1] = false;
			}
		}
	}
}
