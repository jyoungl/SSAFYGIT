import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M {
	static int N, M , arr[], numbers[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		numbers = new int[M];
		Arrays.sort(arr);
		
		perm(0,0);
	}
	
	static void perm(int cnt, int flag) {
		
		if(cnt == M) {
			
			for(int i=0;i<M;i++) {
				System.out.print(arr[numbers[i]]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0; i<N;i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}
			numbers[cnt] = i;
			perm(cnt+1, flag|1<<i);
		}
		
	}

}
