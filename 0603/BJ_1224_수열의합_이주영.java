package jun03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1224_수열의합_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		boolean b = false;
		
		while(L<=100) {
			long s = N/L - (L-1)/2;
			
			if(s < 0)
				break;
			
			if(N == (s*2+L-1)*L/2) {
				for(int i=0;i<L;i++) {
					sb.append(s + i + " ");
				}
				b = true;
				break;
			}
			
			L++;
		}
		
		if(!b)
			sb.append("-1");
		
		System.out.println(sb);
	}

}
