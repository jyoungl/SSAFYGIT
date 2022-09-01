package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1735_분수합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long y1 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		
		long min = Math.min(x2, y2);
		long max = 1;
		for (long i = min; i > 1; i--) {
			if(x2%i == 0 && y2%i == 0) {
				max = i;
				break;
			}
		}
		
		long a = x1*(y2/max) + y1*(x2/max);
		long b = x2*y2/max;

		min = Math.min(a, b);
		max = 1;
		for (long i = min; i > 1; i--) {
			if(a%i == 0 && b%i == 0) {
				max = i;
				break;
			}
		}
		
		System.out.println((a/max) + " " + (b/max));

	}

}
