package jun24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_예산_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int sum = 0;
		int s = 0; int e = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			e = Math.max(arr[i], e);
		}
		
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		if(sum>M) {
			while(s<=e) {
				int m = (s+e)/2;
				int c = 0;
				
				for(int i=0;i<N;i++) {
					if(arr[i]>m)
						c += m;
					else
						c += arr[i];
				}
				
				if(c<=M)
					s = m+1;
				else
					e = m-1;
			}
			System.out.println(e);
		}
		else {
			System.out.println(arr[N-1]);
		}
	}

}
