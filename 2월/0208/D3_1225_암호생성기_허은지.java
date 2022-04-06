package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * .add(1) : 1 추가(공간이 없으면 exception 반환)
 * .offer(1) : 1 추가
 * .poll() : 반환하고 제거
 * .remove() : 제거
 * .clear() : 초기화
 * .peek() : 첫번째 값 참조
 * 
 * 1. 첫줄 TC 테스트 케이스
 * 2. 8개의 데이터
 * 3. 출력 "#" + tc + 답 + " "
 * 
 * >> 숫자 하나씩 뺀 뒤 -1, -2, -3, -4, -5해서 다시 add(계속 반복)
 * >> while(true) + for(<=5)
 * >> if를 써서 0이 나오면 break; (마지막 숫자는 무조건 0 => 0보다 작은 수가 나올 수도 있으니까 마지막에 따로 add)
 */
public class D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_1225_암호생성기.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		while(true) {
			String T = br.readLine();
			if(T == null) break;
			int tc = Integer.parseInt(T);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp = 0;
			
			for(int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			outer: while(true) {
				for(int i = 1; i<= 5; i++) { //1~5 반복
					tmp = queue.poll();
					if((tmp-i) <= 0) break outer; //0이거나 0보다 작아지만 while문 종료
					queue.add(tmp-i);
				}
			}
			
			queue.add(0); //마지막은 무조건 0
			
			//암호문 출력
			System.out.print("#" + tc);
			for(int i = 0; i < 8; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
			
		}//while
	}//main
}//class
