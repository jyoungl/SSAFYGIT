import java.io.*;
import java.util.*;

public class BOJ_1182_부분수열의합 {
	static int[] input;
	static int N,S,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		find(0,0);
		System.out.println(cnt);
	}
	private static void find(int idx,int sum){
		if(idx==N) return;
		if(sum+input[idx]==S) cnt++;
		find(idx+1,sum+input[idx]);
		find(idx+1,sum);
	}
}
