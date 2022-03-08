package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 자연수 N
 * 출력
 * 1. 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지
 * 조건
 * 1. 00이 붙은 타일만 만들 수 있음
 * 
 * >> 1, 2, 3, 5, 8, 13... 피보나치수열로 풀 수 있음
 */
public class s3_1904_01타일 {
	static final int d = 15746;
	static Integer[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		num = new Integer[10000001];
		
		num[0] = 0;
		num[1] = 1;
		num[2] = 2;
		
		Fibonacci(N);
		
		System.out.println(num[N]);
	}

	private static Integer Fibonacci(int n) {
		if(num[n] == null) {
			num[n] = (Fibonacci(n-1) + Fibonacci(n-2)) % d;
		}
		
		return num[n];
		
	}

}
