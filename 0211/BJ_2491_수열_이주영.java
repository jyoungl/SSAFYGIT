package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2491_수열_이주영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 1;
		int min = 1;
		int cnt1 = 1, cnt2=1;
		
		String[] str = br.readLine().split(" ");
		int prev = Integer.parseInt(str[0]);
		
		for(int i=1;i<N;i++) {
			int x = Integer.parseInt(str[i]);
			
			if(x >= prev) {
				cnt1++;
				if(max <= cnt1)
					max = cnt1;
			}
				
			else {
				cnt1 = 1;
			}
				
			if(x <= prev) {
				cnt2++;
				if(min <= cnt2)
					min = cnt2;
			}
	
			else {
				cnt2 = 1;
			}
			prev = x;
		}
		int res = Math.max(max, min);
		System.out.println(res);

		
	}

}
