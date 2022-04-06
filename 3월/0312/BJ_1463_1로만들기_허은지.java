package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 1보다 크거나 같고 10^6보다 작거나 같은 정수 N
 * 출력
 * 1. 연산을 하는 횟수의 최솟값
 * 조건
 * 1. X가 3으로 나누어 떨어지면 3으로 나눈다
 * 2. X가 2로 나누어 떨어지면 2로 나눈다
 * 3. 1로 뺀다
 */
public class s3_1463_1로만들기 {
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		num = new int[N + 1];
		num[0] = num[1] = 0;
		
		//Integer 배열로 받으면 null값으로 받으면 됨 int로 받았기 때문에 -1로 초기화
		for(int i = 2; i<=N; i++) {
			num[i] = -1;
		}
 
		System.out.print(make1(N));
 
	}
 
	static int make1(int N) {
		if (num[N] == -1) {
			if (N % 6 == 0) num[N] = Math.min(make1(N - 1), Math.min(make1(N / 3), make1(N / 2))) + 1;
			else if (N % 3 == 0) num[N] = Math.min(make1(N / 3), make1(N - 1)) + 1;
			else if (N % 2 == 0) num[N] = Math.min(make1(N / 2), make1(N - 1)) + 1;
			else num[N] = make1(N - 1) + 1;
		}
		
		return num[N];

	}

}
