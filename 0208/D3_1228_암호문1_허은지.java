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
 * 1. 첫줄 N 원본 암호문의 길이
 * 2. 두번째줄 원본 암호문(" ")
 * 3. 명령어의 개수(5~10)
 * 4. 명령어: I(삽입) x의 위치 바로 다음에 y개의 숫자를 삽입한다 s는 덧붙일 숫자들이다 => I 3 2 123152 487651
 * 5. 테스트 케이스는 10개
 * 6. 출력 "#" + tc + " " + 수정된 암호문 처음 10개
 * 
 * >> tc만큼 for문
 * >> N만큼 for문 큐 쌓기
 * >> command만큼 for문 명령어 실행
 * >> x의 위치까지 poll, add하고 y개의 숫자 add 한 뒤 나머지도 poll, add
 */
public class D3_1228_암호문1 {
	
	static int N, command, x, y;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_1228_암호문1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			
			queue = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}//큐 쌓기
			
			//System.out.println(queue);
			
			command = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<command; i++) {
				st.nextToken(); //암호문 I
				x = Integer.parseInt(st.nextToken()); //x개만큼 poll&add
				for(int j = 0; j < x; j++) {
					queue.add(queue.poll());
				}
				//System.out.println(queue);
				y = Integer.parseInt(st.nextToken()); //y개의 숫자 삽입
				for(int j = 0; j < y; j++) {
					queue.add(Integer.parseInt(st.nextToken()));
				}
				//System.out.println(queue);
				//나머지 전부 poll&add
				for(int j = 0; j < queue.size()-x-y; j++) {
					queue.add(queue.poll());
				}
				//System.out.println(queue);
			}
			
			System.out.print("#" + tc);
			for(int i = 0; i<10; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
			
		}//tc
	}//main
}//class
