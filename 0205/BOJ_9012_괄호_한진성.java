package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_9012_괄호 {
	static ArrayList<Integer> stack = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i=0;i<K;i++) {
			stack.clear();
			char[] chars = in.readLine().toCharArray();
			for(int j=0;j<chars.length;j++) {
				if(chars[j] == '(') {
					push('(');
				}else if(chars[j] == ')'){
					if(top() == '(') {
						pop();
					}else {
						push(')');
					}
				}
			}
			
			if(isEmpty()) {
				System.out.println("YES");
			}else
			{
				System.out.println("NO");
			}
		}


	}

	
	public static void push(int X) {
		stack.add(X);
	}
	
	public static void pop() {
		if(stack.size() == 0) {
		}else {
			stack.remove(stack.size()-1);
		}
	}
	
	public static void size() {
		System.out.println(stack.size());
	}
	
	public static boolean isEmpty() {
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int top() {
		if(stack.size() == 0) {
			return -1;
		}else {
			return stack.get(stack.size()-1);
		}
	}
}
