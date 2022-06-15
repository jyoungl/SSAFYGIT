package jun15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799_쇠막대기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int res = 0;
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i] == '(')
				stack.push(ch[i]);
			else { // ')'
				if(ch[i-1] == '(') {
					stack.pop();
					res += stack.size();
				}
				else { // ')'
					stack.pop();
					res += 1;
				}
			}
		}
		System.out.println(res);
	}

}
