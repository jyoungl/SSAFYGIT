package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1024_수열의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		while(true) {
			int min = N/L - ((L-1)/2);
			if(min < 0 || L > 100) {
				System.out.println(-1);
				System.exit(0);
			}
			
			int sum = (min*2+L-1)*L/2;
			
			if(sum == N) {
				for (int i = 0; i < L; i++) {
					System.out.print((min+i) + " ");
				}
				System.exit(0);
			}
			
			L++;
			
		}
		
	}

}
