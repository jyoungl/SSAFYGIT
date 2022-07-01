package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1072_게임_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		
		long z = 100 * y/x;
		
		if(z>=99)
			System.out.println("-1");
		else {
			long s = 0;
			long e = 2000000000;
			
			while(s < e) {
				long mid = (s+e)/2;
				long tmp = 100 * (y + mid) / (x + mid);
				
				if(tmp>z) {
					e = mid;
				}
				else {
					s = mid+1;
				}
			}
			System.out.println(String.valueOf(e));
		}
	}

}
