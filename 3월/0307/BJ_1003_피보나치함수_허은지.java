package lv15_동적계획법1;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. N(0<=N<40)
 * 출력
 * 1. 0이 출력되는 횟수와 1이 출력되는 횟수
 * 
 */
public class s3_1003_피보나치함수 {
	static Integer[][] num = new Integer[40][2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		num[0][0] = 1;
		num[0][1] = 0;
		num[1][0] = 0;
		num[1][1] = 1;
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			fibonacci(N);
			
			sb.append(num[N][0]).append(" ").append(num[N][1]).append("\n");
			
		}
		
		System.out.println(sb);

	}

	//int 말고 Integer를 쓰는 이유
	// >> int는 자료형이라 null로 초기화 x
	// >> Integer는 클래스라 null 처리
	private static Integer[] fibonacci(int n) {
		if(num[n][0] == null || num[n][1] == null) {
			num[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			num[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		} 
		
		return num[n];
	}

}
