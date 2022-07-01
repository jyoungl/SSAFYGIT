package jun16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2217_로프_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		int max = 0;
		int cnt = 0;
		for(int i=0;i<N;i++) {
			cnt = (N-i)*arr[i];
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

}
