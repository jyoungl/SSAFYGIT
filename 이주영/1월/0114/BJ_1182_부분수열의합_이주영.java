package jan14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합_이주영 {
	static int[] arr;
	static boolean[] visited;
	static int N,S;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0,0);
		if(S==0)
			System.out.println(ans-1);
		else
			System.out.println(ans);
	}

	public static void back(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S)
				ans++;
			
			return;
		}
		
		back(cnt+1, sum+arr[cnt]);
		back(cnt+1, sum);
	}
}
