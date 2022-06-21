package jun21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1789_수들의합_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		long sum = 0;
		for(long i=1;i<=S;i++) {
			sum += i;
			
			if(S-sum<=i) {
				System.out.println(i);
				break;
			}
		}
	}

}
