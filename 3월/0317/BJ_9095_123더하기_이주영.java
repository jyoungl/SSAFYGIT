package mar17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095_123더하기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] res = new int[11];
		
		res[1] = 1;
		res[2] = 2;
		res[3] = 4;
		
		int max = 3;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n > max) {
				for(int i=4;i<=n;i++) {
					res[i] = res[i-1] + res[i-2] + res[i-3];
				}
				max = n;
			}
			
			sb.append(res[n]+"\n");
		}
		
		System.out.println(sb);
	}

}
