package lv21_이분탐색;

import java.io.*;
import java.util.*;

public class g2_12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		list.add(0);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int max = list.size()-1;
			
			if(list.get(max) < num) list.add(num);
			else if(list.get(max) > num) {
				
				int min = 0;

				while(min < max) {
					int mid = (min+max)/2;
					
					if(list.get(mid)>=num) max = mid;
					else min = mid+1;
					
				}
				
				list.set(max, num);
				
			}
		}
		
		System.out.println(list.size()-1);
		
		

	}

}
