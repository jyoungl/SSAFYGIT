package feb07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9934_완전이진트리_이주영 {
	static int N;
	static int[] arr;
	static StringBuilder[] ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		arr = new int[(int)Math.pow(2, N)-1];
		ans = new StringBuilder[N];
		
		for(int i=0;i<arr.length;i++)
			arr[i] = Integer.parseInt(str[i]);
		
		for(int i=0;i<N;i++)
			ans[i] = new StringBuilder();
		
		solve(0, arr.length-1,0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(ans[i]+"\n");
		}
		System.out.println(sb);
	}

	public static void solve(int s, int e, int cnt) {
		if(cnt == N)
			return;
		
		int mid = (s+e)/2;
		ans[cnt].append(arr[mid] + " ");
		solve(s,mid-1,cnt+1);
		solve(mid+1,e,cnt+1);
	}
}
