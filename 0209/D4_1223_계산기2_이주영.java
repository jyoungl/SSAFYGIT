package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1223_계산기2 {

	public static String post(char[] infix) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		
		for(int i=0;i<infix.length;i++) {
			if(infix[i] == '+') {
				while(!stack.isEmpty()) {
					postfix += stack.pop();
				}
				stack.push(infix[i]);
			}
			else if(infix[i] == '*') {
				stack.push(infix[i]);
			}
			else { //infix[i]가 숫자일 때
				postfix += infix[i];
			}
		}
		
		while(!stack.isEmpty())
			postfix += stack.pop();
		
		return postfix;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			int len = Integer.parseInt(br.readLine());
			char[] infix = br.readLine().toCharArray();
			
			String posfix = post(infix);
			
			char[] po = posfix.toCharArray();
			Stack<Integer> ist = new Stack<>();
			int res = 0;
			
			for(int i=0;i<po.length;i++) {
				if(po[i] == '*') {
					int a = ist.pop();
					int b = ist.pop();
					ist.push(a*b);
					res = a*b;
				}
				else if(po[i] == '+') {
					int a = ist.pop();
					int b = ist.pop();
					ist.push(a+b);
					res = a+b;
				}
				else {
					int a = po[i] - '0';
					ist.push(a);
				}
			}
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}

}
