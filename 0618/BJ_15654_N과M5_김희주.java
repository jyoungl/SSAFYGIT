import java.io.*;
import java.util.*;

public class BOJ_15654_N과M5 {
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] input,pick;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		pick = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		findP(0,0);
		System.out.print(sb);
	}
	private static void findP(int cnt,int flag){
		if(cnt==M){
			for(int i=0;i<M;i++){
				sb.append(pick[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i=0;i<N;i++){
			if((flag&1<<i)!=0) continue;
			pick[cnt] = input[i];
			findP(cnt+1,flag|1<<i);
		}
	}
}
