import java.io.*;
import java.util.*;

public class BOJ_10819_차이를최대로 {
	static int N,MAX = Integer.MIN_VALUE;
	static int[] A, order;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		A = new int[N];
		order = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

		change(0,0);

		System.out.println(MAX);

	}
	private static void change(int cnt, int flag){
		if(cnt==N){
			int tmp = 0;
			for(int i=0;i<N-1;i++){
				tmp += Math.abs(order[i]-order[i+1]);
			}
			if(tmp>MAX) MAX = tmp;
		}
		for(int i=0;i<N;i++){
			if((flag&1<<i)!=0) continue;
			order[cnt] = A[i];
			change(cnt+1,flag|1<<i);
		}
	}
}

