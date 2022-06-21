package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_10610_30 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		
		char[] num = new char[N.length()];
		int sum = 0;
		boolean zero = false;
		
		for (int i = 0; i < N.length(); i++) {
			if(N.charAt(i) == '0') zero = true;
			num[i] = N.charAt(i);
			sum += N.charAt(i);
		}
		
		if(sum % 3 != 0 || !zero) {
			System.out.println(-1);
			return;
		}
		
		Arrays.sort(num);
		
		for (int i = num.length - 1; i >= 0; i--) {
			sb.append(num[i]);
		}
		
		System.out.println(sb);

	}

}
