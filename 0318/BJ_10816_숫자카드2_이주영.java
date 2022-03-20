package mar18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10816_숫자카드2_이주영 {
	static int lower_bound(int[] arrN, int num) {
		int start = 0, last = arrN.length, mid;
		while(start<last) {
			mid = start + (last-start)/2;
			if(num <= arrN[mid]) {
				last = mid;
			}
			else {
				start = mid+1;
			}
		}
		return start;
	}
	static int upper_bound(int[] arrN, int num) {
		int start = 0, last = arrN.length, mid;
		while(start < last) {
			mid = start + (last-start)/2;
			if(num >=arrN[mid])
				start = mid +1;
			else
				last = mid;
		}
		return start;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++){
			int x = Integer.parseInt(st.nextToken());
			
			int y = upper_bound(a,x) - lower_bound(a,x);
			
				sb.append(y+" ");
			
			
		}
		
		System.out.println(sb);
	
	}

}
