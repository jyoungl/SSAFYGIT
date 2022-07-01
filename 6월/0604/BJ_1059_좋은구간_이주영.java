package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1059_좋은구간_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		
		int[] arr = new int[L];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<L;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int sum = 0;
		
		if(arr[0] > n) {
			sum += (n-1) * (arr[0]-n);
			sum += (arr[0] - n - 1);
		}
		else {
			for(int i=0;i<L-1;i++) {
				if(arr[i] < n && arr[i+1] > n) {
					int tmp = arr[i+1]-n;
					sum += (tmp - 1);
					sum += ((n - arr[i] -1) * tmp);
				}
			}
		}	
		
		System.out.println(sum);
	}

}
