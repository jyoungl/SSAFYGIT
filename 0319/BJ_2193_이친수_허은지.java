package A형대비;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. N
 * 출력
 * 1. N자리 이친수의 개수
 * 조건
 * 1. 0으로 시작하지 않음
 * 2. 1이 두 번 연속으로 나오지 않음
 * 
 * >> 1 1 2 3 5 8 ... 피보나치
 */
public class s3_2193_이친수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[90];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i<N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[N-1]);

	}

}
