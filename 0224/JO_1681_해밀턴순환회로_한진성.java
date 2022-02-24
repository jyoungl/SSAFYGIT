import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {

	
	static int N, arr[][],ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(1,0,new boolean[N],0);
		System.out.println(ans);
	}

	
	public static void dfs(int cnt,int v, boolean[] visited, int dist) {
		
		// 가지치기 1 현재 거리가 최소거리보다 크면 리턴
		if(dist > ans) {
			return;
		}
		
		// N번째 지점에 도달 했을 떄
		if(cnt == N) {
			// 시작지점으로 돌아갈 수 있다면, 그 값을 더한 최종 거리들의 최솟값 구하기
			if(arr[v][0] != 0 && ans > dist + arr[v][0]) {
				ans = dist + arr[v][0];
			}
			return;
		}
		
		// dfs(순열)
		for(int i=1;i<N;i++) {
			if(!visited[i] && arr[v][i] != 0) {
				visited[i] = true;
				dfs(cnt+1,i,visited,dist + arr[v][i]);
				visited[i] = false;
			}
		}
		
	}
	
}
