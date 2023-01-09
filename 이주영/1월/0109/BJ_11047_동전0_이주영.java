package jan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11047_동전0_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int ans = 0;
		for(int i=N-1;i>=0;i--) {
			if(arr[i] <= K) {
				while(arr[i]<=K) {
					K -= arr[i];
					ans++;
				}
			}
			
			if(K == 0)
				break;
		}
		
		System.out.println(ans);
	}

}
