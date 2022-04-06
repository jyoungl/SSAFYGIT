import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int N;
	static int arr[][];
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		arr = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		
		System.out.println(answer);
	}
	
	
	public static void dfs(int cnt, int sum) {
		
		if(cnt == N) {
			answer = Math.max(answer,sum);
			return;
		}
		
		// 가지치기 1
		if(cnt >= N) {
			return;
		}
		
		// 현재 위치를 선택하지 않는 경우
		dfs(cnt+1, sum);
		
		// 현재 위치를 선택하는 경우
		sum = sum + arr[cnt][1];
		cnt = cnt + arr[cnt][0];
		
		dfs(cnt, sum);
		
	}

}
