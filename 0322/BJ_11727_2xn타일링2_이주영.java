package mar22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727_2xn타일링2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] res = new int[1001];
		res[1] = 1;
		res[2] = 3;
		
		for(int i=3;i<=n;i++) {
			res[i] = (res[i-1] + res[i-2]*2)%10007;
		}
		
		System.out.println(res[n]);
	}

}
