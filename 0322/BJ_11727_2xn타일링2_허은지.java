package A형대비;

import java.io.*;
import java.util.*;

/*
 * 
 */
public class s3_11727_2xn타일링2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[1001];
		
		num[0] = 1;
		num[1] = 3;
		
		for(int i = 2; i<N; i++) {
			num[i] = (num[i-1] + (num[i-2]*2))%10007;
		}
		
		System.out.println(num[N-1]);
	}
}
