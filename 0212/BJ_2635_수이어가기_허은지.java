package boj;

import java.util.*;
import java.io.*;

/*
 * 1. 입력: 첫번째 수 N <=30000
 * 2. 임의의 수 K(첫번째 수보다 작음)을 선택해 빼서 3번째 수를 만들고, 2-3을 해서 4번째 수를 만듦
 * 3. 음의 정수가 만들어지면 음의 정수를 버리고 더 이상 수를 만들지 않음
 * 
 * >> 브루트포스?? 첫 번째 수 N 이하의 수 중 경우의 수를 모두 구해서 가장 많은 경우를 세기
 */
public class s5_2635_수이어가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num1, num2, num3 = 0;
		int max = 0;
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			num1 = N;
			num2 = i;
			int count = 2;
			
			while(num1>=num2) { //음수 나오면 종료
				num3 = num1 - num2;
				num1 = num2;
				num2 = num3;
				count++;
			}
			list.add(i, count);
			max = Math.max(max, count);
		}//for
		
		System.out.println(max);
		
		num1 = N;
		num2 = list.indexOf(max);
		sb.append(num1).append(" ").append(num2);
		
		while(num1>=num2) { //음수 나오면 종료
			num3 = num1-num2;
			num1 = num2;
			num2 = num3;
			sb.append(" ").append(num3);
		}
		System.out.print(sb);
	}//main
}//class
