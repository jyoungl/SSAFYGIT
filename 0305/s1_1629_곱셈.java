

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. A B C
 * 출력
 * 1. A를 B 번 곱한 수 이를 C로 나눈 나머지
 * 
 * >> B를 반으로 계속 쪼개서 1이 나오면 계산
 * >> A를 C로 나눠서 나머지를 계산
 */
public class s1_1629_곱셈 {
	static long A, B, C;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		ans = pow(A%C, B);
		
		System.out.println(ans%C);
	}

	private static long pow(long a, long b) {
		System.out.println("리턴" + b);
		//b가 0일 때 1 리턴
		if(b==0) return 1;
		//b가 1일 때 a 리턴
		if(b==1L) return a;
		
		ans = pow(a, b/2);
		System.out.println("리턴" + b);
		//ans = ans%C * ans%C;
		ans = ans*ans%C;
		
		//b가 홀수일 경우 a를 한 번 더 곱해 줌
		//if(b%2==1L) ans *= A%C;
		if(b%2==1L) ans *= A;
		
		//return ans;
		return ans%C;
	}

}
