import java.io.*;
import java.util.*;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());

		long sum;
		int count = 0;

		for(int first = 0;first<N;first++){
			sum = 0;
			for(int last=first;last<N;last++){
				sum += input[last];
				if(sum==M) count++;
				if(sum>=M) break;
			}
		}

		System.out.println(count);
	}
}
