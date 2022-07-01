package 문제풀이;

import java.io.*;
import java.util.*;

public class B2_1100_하얀칸 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] chess = new int[8][8];
		
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				if((i+j)%2==0 && str.charAt(j)=='F') cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
