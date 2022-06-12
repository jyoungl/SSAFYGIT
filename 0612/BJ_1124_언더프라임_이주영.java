package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1124_언더프라임_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100001];
		boolean[] arr = new boolean[100001];
		
		arr[0] = arr[1] = true;
		
		for(int i=2;i<=100000;i++) {
			if(!arr[i]) {
				dp[i] = 1;
				for(int j=i*2;j<=100000;j+=i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i=2;i<=B;i++) {
			if(dp[i] == 0) {
				for(int j=2;;j++) {
					if(i%j==0) {
						dp[i] = dp[i/j]+1;
						break;
					}
				}
			}
		}
		
		int res = 0;
		for(int i=A;i<=B;i++) {
			if(!arr[dp[i]])
				res++;
		}
		
		System.out.println(res);
	}

}
