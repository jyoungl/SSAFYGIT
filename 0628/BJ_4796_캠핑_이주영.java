package jun28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4796_캠핑_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int l, p, v;
		int res = 0;
		int cnt = 1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			if(l==0 && p==0 && v==0)
				break;
			
			res = ((v/p)*l) + Math.min(l, (v%p));
			System.out.println("Case " + cnt++ + ": " + res);
		}
	}

}
