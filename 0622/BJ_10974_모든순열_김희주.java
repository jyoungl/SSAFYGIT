import java.io.*;

public class BOJ_10974_모든순열 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] pick;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		pick = new int[N];
		permutation(0,0);
		System.out.print(sb);
	}
	private static void permutation(int cnt, int flag){
		if(cnt==N){
			for(int i=0;i<N;i++){
				sb.append(pick[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0;i<N;i++){
			if((flag&1<<i)!=0) continue;
			pick[cnt] = i+1;
			permutation(cnt+1,flag|1<<i);
		}
	}
}
