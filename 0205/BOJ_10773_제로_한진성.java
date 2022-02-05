package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_10773_제로 {
	static ArrayList<Integer> stack = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i=0;i<K;i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				pop();
			}else
			{
				push(num);
			}
		}
		int answer = 0;
		for(int i=0;i<stack.size();i++) {
			answer += stack.get(i);
		}
		
		System.out.println(answer);

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
	
	public static void empty() {
		if(stack.size() == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
	
	public static void top() {
		if(stack.size() == 0) {
			System.out.println("-1");
		}else {
			System.out.println(stack.get(stack.size()-1));
		}
	}
}
