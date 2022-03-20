package mar17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기_이주영 {
	public static int binarySearch(int[] A, int x) {
		int l = 0;
		int r = A.length - 1;
		int b = 0;
		
		while(l <= r) {
			int mid = (l+r)/2;
			
			if(x <A[mid]) {
				r = mid-1;
			}
			else if(x>A[mid]) {
				l = mid + 1;
			}
			else {
				b = 1;
				break;
			}
		}
		
		return b;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int x = Integer.parseInt(st.nextToken());
			int res = binarySearch(A, x);
			sb.append(res+"\n");
		}
		
		System.out.println(sb);
	}

}
