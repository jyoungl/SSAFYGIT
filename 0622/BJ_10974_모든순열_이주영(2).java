package jun22;

import java.util.Scanner;

public class BJ_10974_모든순열_이주영 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] b;
	public static void per(int N, int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++)
				sb.append(arr[i]+ " ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(b[i])
				continue;
			
			arr[cnt] = i;
			b[i] = true;
			per(N, cnt+1);
			b[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		arr = new int[N+1];
		b = new boolean[N+1];
		per(N,0);
		System.out.println(sb);
	}

}
