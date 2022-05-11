package im형필수문제;

import java.io.*;
import java.util.*;

public class B2_13458_시험감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		
		st = new StringTokenizer(br.readLine());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			if(arr[i] <= B) {
				sum++;
				continue;
			}
			sum += (arr[i]-B)/C + 1;
			if((arr[i]-B)%C!=0) sum++;
		}
		
		System.out.println(sum);

	}

}
