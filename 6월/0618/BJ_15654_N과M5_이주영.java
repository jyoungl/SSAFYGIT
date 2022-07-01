package jun18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M5_이주영 {
	static StringBuilder sb = new StringBuilder();
	static int[] res;
	static boolean[] b;
	public static void func(int[]arr, int M, int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++)
				sb.append(res[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!b[i]) {
				b[i] = true;
				res[cnt] = arr[i];
				func(arr,M,cnt+1);
				b[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		b = new boolean[N];
		res = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		func(arr,M,0);
		System.out.println(sb);
	}

}
