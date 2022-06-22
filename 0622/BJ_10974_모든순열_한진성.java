import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10974_모든순열 {

	static int N, numbers[];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		numbers = new int[N];
		sb = new StringBuilder();
		perm(0,0);
		System.out.println(sb);
	}

	static void perm(int cnt, int flag) {
		
		if(cnt==N) {
			
			for(int num : numbers) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1;i<=N;i++) {
			
			if((flag & 1<<i) != 0) {
				continue;
			}
			
			numbers[cnt] = i;
			
			perm(cnt+1, (flag | 1<<i));
			
		}
		
		
		
		
	}
	
}
