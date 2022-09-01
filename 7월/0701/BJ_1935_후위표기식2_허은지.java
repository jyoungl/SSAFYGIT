package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		char[] ch = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		
		double[] num = new double[26];
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for(char c : ch) {
			if('A' <= c && c <= 'Z') stack.push(num[c-'A']);
			else {
				switch(c) {
				case '+':
					stack.push(stack.pop()+stack.pop());
					break;
				case '-':
					double tmp = stack.pop();
					stack.push(stack.pop()-tmp);
					break;
				case '*':
					stack.push(stack.pop()*stack.pop());
					break;
				case '/':
					tmp = stack.pop();
					stack.push(stack.pop()/tmp);
					break;
				}
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));

	}

}
