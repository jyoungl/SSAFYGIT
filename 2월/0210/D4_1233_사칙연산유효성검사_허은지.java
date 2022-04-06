package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스는 10개
 * 2. 첫 줄에 정점의 총  수 N
 * 3. 연산이 가능하면 1, 불가능하면 0
 * 4. 출력: "#" + tc + " " + result
 * 
 * >> 서브 트리가 없는데 숫자가 아니면 무조건 불가능
 * >> 서브 트리가 있는데 사칙연산이 아니면 무조건 불가능
 * >> st 길이 잰 뒤 2번째 숫자 보기
 */
public class D4_1233_사칙연산유효성검사 {
	static BufferedReader br; //함수를 쓰기 위해서 static으로 정의
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D4_1233_사칙연산유효성검사.txt");
		br = new BufferedReader(new FileReader(file));
		//br = new BufferedReader(new InputStreamReader(System.in));
		
		outer: for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String s = st.nextToken(); //정점 저장
				
				if(st.countTokens()==0 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
					//서브 트리가 있는데 정점에 연산자가 있는 경우 연산 불가능
					System.out.println("#" + tc + " 0");
					trash(N-i); //남은 식은 필요없기 때문에 건너뛰기
					continue outer;
				}
				else if(st.countTokens()==2 && !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
					//서브 트리가 있는데 정점에 연산자가 있는 경우 연산 불가능
					System.out.println("#" + tc + " 0");
					trash(N-i); //남은 식은 필요없기 때문에 건너뛰기
					continue outer;
				}
			}
			System.out.println("#" + tc + " 1");
		}
	}

	public static void trash(int num) throws IOException {
		for(int i = 0; i<num; i++) {
			br.readLine();
		}
	}
	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		File file = new File("D4_1233_사칙연산유효성검사.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		for(int tc = 1; tc <= 10; tc++) {
//			int N = Integer.parseInt(br.readLine());
//			int result = 1;
//			
//			for(int i = 1; i <= N; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				
//				st.nextToken();
//				String s = st.nextToken(); //정점 저장
//				
//				if(st.countTokens()==0 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
//					//서브 트리가 없는데 정점에 연산자가 있는 경우 연산 불가능
//					result = 0;
//				}
//				else if(st.countTokens()==2 && !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
//					//서브 트리가 있는데 정점에 연산자가 있는 경우 연산 불가능
//					result = 0;
//				}
//			}
//			System.out.println("#" + tc + " " + result);
//		}
//	}
}
