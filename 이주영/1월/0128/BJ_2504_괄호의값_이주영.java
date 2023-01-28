package jan28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504_괄호의값_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack();
		String ans = "";
		int val = 1;
		int res = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.push(c);
				val *= 2;
			}
			else if(c == '[') {
				stack.push(c);
				val *= 3;
			}
			else if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					res = 0;
					break;
				}
				else if(s.charAt(i-1) == '(')
					res += val;
				
				stack.pop();
				val /= 2;
			}
			else if(c == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					res = 0;
					break;
				}
				else if(s.charAt(i-1) == '[')
					res += val;
				
				stack.pop();
				val /= 3;
			}
		}
		
		if(!stack.isEmpty())
			System.out.println(0);
		else
			System.out.println(res);
	}

}
