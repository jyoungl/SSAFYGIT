import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2060_바이러스 {
	static int N;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(in.readLine());
		
		int C = Integer.parseInt(in.readLine());
		
		int[][] arr = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(in.readLine()," ");
			
			int from = Integer.parseInt(st.nextToken());
			
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = 1;
			arr[to][from] = 1;
			
		}
		
		dfs(arr,new boolean[N+1],1);
		
		
		System.out.println(cnt);
//		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
	}

	public static void dfs(int[][] arr, boolean[] isVisited, int V) {
		isVisited[V] = true;

		for(int i=1;i<=N;i++) {
			if(!isVisited[i] && arr[V][i] == 1) {
				cnt++;
				dfs(arr, isVisited, i);
			}
		}
		
	}
	
}
