import java.io.*;
import java.util.*;

public class BOJ_1449_수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);

		double prev = input[0]+L-0.5;
		int count=1;
		for(int i=1;i<N;i++){
			if(input[i]>prev) {
				count++;
				prev = input[i]+L-0.5;
			}
		}

		System.out.println(count);
	}
}
