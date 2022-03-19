import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2805
public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		long max = 0,min=0;
		long[] trees = new long[N];

		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) max = Math.max(max,trees[i] = Long.parseLong(st.nextToken()));

		long mid, count;
		while(min<=max){
			mid = (min+max)/2;
			count = 0;
			for(int i=0;i<N;i++) if(trees[i]>mid) count += trees[i]-mid;

			if(count<M) max = mid-1;
			else min = mid+1;
		}

		System.out.println(max);

	}
}
