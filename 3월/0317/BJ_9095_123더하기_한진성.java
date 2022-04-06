import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	
	static int cnt, N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=0;tc<T;tc++) {
			
			N = Integer.parseInt(in.readLine());
			cnt = 0;
			dfs(1,0);
			
			System.out.println(cnt);
			
		}
	}

	public static void dfs(int x, int val) {
		// 기저조건
		if(val == N) {	
			cnt++;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(val < N) {
				dfs(i, val+i);
			}
		}
		
	}
}
