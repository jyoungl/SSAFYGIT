package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1052_물병 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		while(true) {
			int cnt = 0;
			int num = N;
			
			while(num>=1) {
				if(num%2==1) cnt++;
				num /= 2;
			}
			
			if(cnt <= K) break;
			
			ans++;
			N++;
		}
		
		System.out.println(ans);

	}

}
