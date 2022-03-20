package mar21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[N];
		st = new StringTokenizer(br.readLine());
		
		long max = 0;
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i])
				max = tree[i];
		}
		
		long l = 0;
		
		while(l < max) {
			long cnt = 0;
			long mid = (l+max)/2;
			
			for(int i=0;i<N;i++) {
				if(tree[i] > mid)
					cnt += tree[i] - mid;
			}

			if(cnt < M) {
				max = mid;
			}
			else
				l = mid + 1;
		}
		
		System.out.println(max-1);
	}

}
