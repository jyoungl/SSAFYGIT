package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * 1. 한줄씩 문장이 들어옴
 * 2.  . 같은 것도 균형잡힌 문자열
 * 3. . 찍으면 종료
 * 
 * >> 괄호 포함되면 스택에 쌓음 ( [ 면 쌓고 ) ] 면 지움
 * 		>> )나 ]가 나오면 peek 보고 (나 [일 때만 지움 아니면 no 출력
 * >> 스택 벗어나면 no 출력
 * >> 마지막에 스택 empty면 yes 출력
 */
public class lv18_4949_균형잡힌세상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		outer: while(true) { 
			String str = br.readLine();
			if(str.equals(".")) break; //str이 .면 멈추기
			Stack<String> stack = new Stack<>();
			for(int i = 0; i<str.length(); i++) {
				char c = str.charAt(i); //한글자씩 읽기
				
				switch(c) {
				case '(': // ( 일때 쌓기
					stack.push("(");
					break;
				case ')':				
					try {
						if(stack.peek().equals("(")) stack.pop(); //가장 위에 있는 게 ( 일 때 ) 만나서 삭제
						else {System.out.println("no"); continue outer;} //아니면 no 출력
					} catch(EmptyStackException e) {
						System.out.println("no"); //stack 벗어나면 no 출력
						continue outer;
					}
					break;
				case '[':
					stack.push("[");
					break;
				case ']':
					try {
						if(stack.peek().equals("[")) stack.pop();
						else {System.out.println("no"); continue outer;}
					} catch(EmptyStackException e) {
						System.out.println("no");
						continue outer;
					}
					break;
				}
			}
			
			if(stack.empty()==true) { System.out.println("yes");} // 스택 비어있으면 yes
			else { System.out.println("no");} // 남아있으면 no
		}
	}
}
