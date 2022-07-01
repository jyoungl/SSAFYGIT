package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] num = new int[2];
		num[str.charAt(0) - '0']++;

		for (int i = 1; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if(str.charAt(i-1) - '0' != n) num[n]++;
		}
		
		System.out.println(Math.min(num[0], num[1]));

	}

}
