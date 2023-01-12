package jan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107_리모컨_이주영 {
	static boolean[] btn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		btn = new boolean[10];
		
		if(M!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				int x = Integer.parseInt(st.nextToken());
				btn[x] = true;
			}
		}
		int min_cnt = Math.abs(N-100);
		
		for(int i=0;i<=1000000;i++) {
			int len = check(i);
			
			if(len > 0) {
				int cnt = Math.abs(N-i);
				min_cnt = Math.min(cnt+len, min_cnt);
			}
		}
		
		System.out.println(min_cnt);
	}

	public static int check(int x) {
		if(x==0) {
			if(btn[0])
				return 0;
			else
				return 1;
		}
		
		int ans = 0;
		while(x>0) {
			if(btn[x%10]) {
				return 0;
			}
			x /= 10;
			ans += 1;
		}
		
		return ans;
	}
}
