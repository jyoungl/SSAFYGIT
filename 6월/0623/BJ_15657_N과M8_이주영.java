package jun23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657_N과M8_이주영 {
	static int[] arr;
	static int[] res;
	static boolean[] b;
	static StringBuilder sb = new StringBuilder();
	
	public static void func(int N, int M, int s, int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=s;i<N;i++) {
//			if(b[i])
//				continue;
			//b[i] = true;
			res[cnt] = arr[i];
			func(N,M,i,cnt+1);
			//b[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res = new int[M];
		b = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		func(N,M,0,0);
		System.out.println(sb);
	}

}
