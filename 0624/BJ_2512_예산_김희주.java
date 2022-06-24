import java.io.*;
import java.util.*;

public class BOJ_2512_예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		int M = Integer.parseInt(in.readLine());

		int low=0,high=input[N-1];
		int mid,sum;
		while(low<=high){
			mid = (low+high)/2;
			sum = 0;
			for(int i=0;i<N;i++){
				sum += Math.min(mid,input[i]);
			}
			if(sum>M) high = mid-1;
			else low = mid+1;
		}

		System.out.println(high);
	}
}
