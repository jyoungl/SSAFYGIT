package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_1072_게임 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());

		double Z = Y*100/X;
		
		if((int)Z >= 99) {
			System.out.println(-1);
			return;
		}
		
		int tmp = (int)Z;
		
		long min = 0;
		long max = 2000000000;
		
		while(min < max) {
			long mid = (min+max)/2;
			
			Z = (Y+mid)*100/(X+mid);
			
			if(Z > tmp) max = mid;
			else min = mid+1;
		}
		
		System.out.println(max);

	}

}
