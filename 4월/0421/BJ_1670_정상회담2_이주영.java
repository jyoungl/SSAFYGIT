package apr21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1670_정상회담2_이주영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] res = new long[N+1];
		int M = 987654321;
		res[0] = 1;
		res[2] = 1;
		
		for(int i=4;i<=N;i+=2) {
			for(int j=2;j<=i;j+=2) {
				res[i] = (res[i] + (res[j]*res[i-j-2])%M)%M;
			}
		}
		
		System.out.println(res[N]);
	}

}
