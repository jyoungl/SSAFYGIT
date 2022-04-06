package feb24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_17413_단어뒤집기2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		boolean b = false;
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				b = true;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append("<");
			} 
			else if(ch == '>') {
				b = false;
				sb.append(">");
			} 
			else if(ch == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(" ");
			} 
			else {
				if(!b) // 태그 밖
					stack.push(ch);
				else // 태그 안.
					sb.append(ch);
			}
		}
		
		// 스택에 남은 문자 뒤집기.
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[] str = br.readLine().toCharArray();
//		
//		int i =0;
//		String res = "";
//		while(true) {
//			if(i == str.length)
//				break;
//			//태그일 때
//			if(str[i] == '<') {
//				while(str[i] != '>') {
//					res += str[i++];
//				}
//				res += str[i++];
//			}
//			else if(str[i] == ' ')
//				res += str[i++];
//			
//			//단어일 때
//			else {
//				String temp = "";
//		
//				while(i<str.length && str[i] != '<' && str[i] != ' ') {
//					temp += str[i];
//					i++;
//				}
//				char[] te = temp.toCharArray();
//				for(int j=temp.length()-1;j>=0;j--) {
//					res += te[j];
//				}
//			}
//		}
//		System.out.println(res);

	}

}
