/*
15 = 3 * 5

15 를 4로 나눈 나머지 = 3

3을 4로 나눈 나머지 = 3
5를 4로 나눈 나머지 = 1
>> 3*1 을 4로 나눈 나머지 = 3
==============================================================

식으로 접근해보자
A = n1a+m1
B = n2a+m2
A*B = n1*n2*a^2 + n1a*m2 + n2a*m1 + m1*m2 인데
이때 앞의 세 항은 a(나누는 수, 위의 경우 4)로 나누어 떨어진다
따라서 m1*m2 (mod a)의 A*B의 나머지가 되는데
이때 m1은 A (mod a) 이고
이때 m2는 B (mod a) 이므로
AB (mod a) = ( A (mod a) * B (mod a) ) (mod a)
 */
package com.ssafy;

import java.util.*;
import java.io.*;

public class BJ_1629_곱셈 {

	// A, B, C는 모두 2,147,483,647 이하의 자연수이므로 정수형 범위 만족
	static long A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// (10x10x10x10x10x10x10x10x10x10x10)%12
		/*
		 * int result = (int)Math.pow(A, B)%(int)C; 
		 * System.out.println((int)Math.pow(A,B)); // 2147483647 
		 * System.out.println(result); // 7
		 */

		/*
		 * double result = Math.pow(A, B) % C; 
		 * System.out.println(Math.pow(A, B)); // 1.0E11 
		 * System.out.println((int)result); // 4
		 */

		long result = 1;
		long multiply = A % C;
		
		while(B > 0){
			if(B % 2 == 1){ // B가 홀수면
				result = result * multiply;
				result = result % C;
			}
			multiply = ((multiply % C) * (multiply % C)) % C;
			B/=2;
		}
		System.out.print(result);
	}
}