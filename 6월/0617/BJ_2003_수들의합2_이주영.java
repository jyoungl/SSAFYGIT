package jun17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res= 0;
		for(int i=0;i<N;i++) {
			int x = arr[i];
			if(x<M) {
				int sum = x;
				for(int j=i+1;j<N;j++) {
					sum += arr[j];
					if(sum==M) {
						res++;
						break;
					}
					else if(sum>M)
						break;
				}
			}
			else if(x==M)
				res++;
		}
		System.out.println(res);
	}

}
