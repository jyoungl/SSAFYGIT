import java.io.*;
import java.util.*;

public class BOJ_1059_좋은구간 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] S = new int[L];
		for(int i=0;i<L;i++) S[i] = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());

		Arrays.sort(S);
		int idx = Arrays.binarySearch(S,N);
		if(idx>=0){
			System.out.println(0);
			return;
		}

		idx = -idx-1;

		if(idx==0){
			System.out.println((N-1)*(S[0]-N-1)+(N-1)+(S[0]-N-1));
		}else{
			System.out.println((N-S[idx-1]-1)*(S[idx]-N-1)+(N-S[idx-1]-1)+(S[idx]-N-1));
		}

	}
}
