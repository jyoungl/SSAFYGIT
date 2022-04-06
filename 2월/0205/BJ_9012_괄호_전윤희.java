package com.baekjoon.study06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * output 달랐던 이유 :
 * '('과 ')' 개수 비교(각각 3개씩 있어도 VPS 아님)가 아닌 가장 가까운 괄호와 짝이 맞아야함
 * 
 * String 값을 문자 타입의 스택으로 넣어서
 * '(' 가 먼저 들어오면 스택에 넣고, ')'가 오면 VPS이기 때문에 짝인 '('이 pop
 * 비어있는 스택에 ')'가 들어오면 VPS가 아니기 때문에 VPS는 fasle
 */
public class stack_9012_괄호 { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		//Stack<Character> stack = new Stack<>();
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean vps = true;
			
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				if(c=='(') { //기준 '('
					stack.push(c);
				} else { // ')' 들어오기전 짝이 있는지 체크
					if(stack.isEmpty()) { // ')' 혼자 있음(짝 x)
						vps = false;
					} else if(!stack.isEmpty()) { 
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty() && vps ==true) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
