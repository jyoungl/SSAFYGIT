package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D4_1223_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_1223.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(in.readLine());
			
			char[] chars = in.readLine().toCharArray();
	//		char[] chars = "3+4+5*6+7".toCharArray();
	
			Stack<Character> stack = new Stack<>();
			List<Character> list = new ArrayList<>();
			// 후위표기법으로 만들기
			for(int i=0;i<N;i++) {
				char m = chars[i];
				switch(m) {
				case '*':
					stack.push(m);
					break;
				case '+':
					while(!stack.isEmpty()) {
						list.add(stack.pop());
					}
					stack.push(m);
					break;
				default:
					// 숫자면 다 넣기
					list.add(m); 
				}
			}
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
			
	//		// 잘 변환 되었다. 
	//		System.out.println(list+"\n");
			
			Stack<Integer> stack2 = new Stack<>();
			// 후위표기법 계산하기
			for(int i=0;i<N;i++) {
				char m = list.get(i);
				switch(m) {
				case '+':
					stack2.push(calcul(stack2.pop(),stack2.pop(),m));
					break;
				case '*':
					stack2.push(calcul(stack2.pop(),stack2.pop(),m));
					break;
				default:
					stack2.push(m-'0');
				}
			}
			int answer = stack2.pop();
			System.out.printf("#%d %d\n",tc,answer);
		}
	}
	
	public static int calcul(int A, int B, char cal) {
		switch(cal) {
		case '+':
			return A + B;
		case '*':
			return A * B;
		}
		return -1;
	}
}
