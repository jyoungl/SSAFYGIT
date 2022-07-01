package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;

		while(true) {
			if(N < 5) break;
			ans += N/5;
			N /= 5;
		}
		
		System.out.println(ans);

	}

}
