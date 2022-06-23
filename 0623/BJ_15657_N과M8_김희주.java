import java.io.*;
import java.util.*;

public class BOJ_15657_N과M8 {
	static int N,M;
	static int[] A,select;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		A = new int[N];
		select = new int[M];
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		pick(0,0);
		System.out.print(sb);
	}
	private static void pick(int cnt, int start){
		if(cnt==M){
			for(int i=0;i<M;i++){
				sb.append(select[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=start;i<N;i++){
			select[cnt] = A[i];
			pick(cnt+1,i);
		}
	}
}
