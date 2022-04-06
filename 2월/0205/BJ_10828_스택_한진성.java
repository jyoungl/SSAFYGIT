package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_10828_스택 {

	static ArrayList<Integer> stack = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0;i<N;i++) {
			String[] str = in.readLine().split(" ");
			switch(str[0]) {
			case "push":
				push(Integer.parseInt(str[1]));
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;
			}
		}

	}

	
	public static void push(int X) {
		stack.add(X);
	}
	
	public static void pop() {
		if(stack.size() == 0) {
			System.out.println("-1");
		}else {
			System.out.println(stack.get(stack.size()-1));
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
