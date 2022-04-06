package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1224_계산기3 {

	/*
	 * 1. 10개의 테스트 케이스
	 * 2. 첫 줄에 테스트 케이스의 길이 N
	 * 3. 테스트케이스
	 * 4. 후위 표기식으로 바꿔야 함 >> 스택 사용
	 * 5. +, *가 나오면 계산하고 아니면 숫자 저장하기 >> switch?? >> if
	 * 6. 괄호가 있으면 ( 스택에 저장한 뒤 )가 뜨면 (가 나올 때까지 pop
	 * 7. 출력: "#" + tc + " " + result;
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_1224_계산기3.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> s1 = new Stack<>(); //후위식으로 바꾸기
		Stack<Integer> s2 = new Stack<>(); //식 계산
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine(); //받은 식
			String cal = ""; //후위식
			
			for(int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if(c-'0' >= 0 && c-'0' <= 9) {//c가 숫자라면
					cal += c;
				} else if(c == '*') { //*일때
					s1.push(c);
				} else if(c == '+') { //+일때
					while(!s1.empty() && (s1.peek() == '*' || s1.peek() == '+')) cal+=s1.pop(); //*보다 우선순위가 낮기 때문에 *가 있으면 pop
					s1.push(c);
				} else if(c == '(') { //(일때
					s1.push(c);
				} else if(c == ')') { //)일때
					while(!s1.empty() && s1.peek() != '(') {
						cal+=s1.pop();//(나올 때까지 pop
					}
					if(!s1.empty()) {
						s1.pop(); //(꺼내주기
					}
				}
			}
			
			while(!s1.empty()) cal+=s1.pop(); //남은 식 전부 cal로 넣기
			
			//System.out.println(cal);
			
			for(int i = 0; i < cal.length(); i++) {
				char c = cal.charAt(i);
				if(c-'0' >= 0 && c-'0' <= 9) {//c가 숫자라면
					s2.push(c-'0'); //s2에 넣기
				} else if(c == '+') {
					s2.push(s2.pop() + s2.pop()); //숫자 두 개 꺼내서 더한 뒤 다시 넣기
				} else if(c == '*') {
					s2.push(s2.pop() * s2.pop()); //숫자 두 개 꺼내서 곱한 뒤 다시 넣기
				}
			}
			System.out.println("#" + tc + " " + s2.pop());
		}

	}

}
