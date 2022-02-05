package silver4; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * T개의 테스트 데이터
 * 괄호 문자열 () 쌍이 맞아야 괄호 YES
 * 
 * 1. 마지막 문자가 ( or 처음 문자가 )면 NO 출력
 * 2. 1 아닐 때 개수(쌍) 안 맞으면 NO 출력
 * 
 * >> 스택으로 쌓아서 (면 + )면 - >> 마지막 스택값이 0이면 yes 아니면 no
 *  ++ )일 때 - 해서 스택 벗어나면 NO
 */
public class lv18_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 데이터

		outer: for(int i = 0; i < T; i++) {
			Stack<String> stack = new Stack<>(); //string형 스택 선언 
			String ps = br.readLine(); //한줄씩 받아서
			for(int j = 0; j < ps.length(); j++) {
				char p = ps.charAt(j); //한글자씩 나눔
				if(p == '(') stack.push("("); // ( 는 쌓기
				try {
				if(p == ')') stack.pop(); // ) 는 삭제
				} catch(EmptyStackException e) { 
					System.out.println("NO"); // 스택 벗어나면 NO 출력
					continue outer; // 아래 empty 검사 없이 다음 줄 실행
				}
			}
			if(stack.empty()==true) { System.out.println("YES");} // 마지막 스택이 비어있으면 YES
			else { System.out.println("NO");} // 남아있으면 NO
		}
	}
}
