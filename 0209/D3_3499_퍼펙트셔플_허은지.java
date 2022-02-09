package com.ssafy.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {

	/*
	 * 1. 테스트 케이스 T
	 * 2. 카드 개수 N
	 * 3. 카드 이름이 공백으로 구분
	 * 4. 홀수일 경우 앞에 있는 부분에 +1
	 * 5. 출력 "#" + tc + result
	 * 
	 * >> N 크기 반의 큐 두개에 넣고 하나씩 번갈아 출력
	 * >> 원본을 변경할 건지 유지할 건지?
	 * >> 카드의 개수가 홀수일 때는 어떻게 할 건지?
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("D3_3499_퍼펙트셔플.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				if(i<=(N+1)/2) q1.add(st.nextToken());
				//N+1을 하는 이유: 홀수일 경우 하나를 더 넣기 위해 7>4까지 9>5까지 넣기
				else q2.add(st.nextToken());
			}
			
			System.out.print("#" + tc);
			for(int i = 0; i < N; i++) {
				if(i%2==0) System.out.print(" " + q1.poll());
				else System.out.print(" " + q2.poll());
			}
			System.out.println();
			
		}
	}
}

//런타임에러
//
//public static void main(String[] args) throws NumberFormatException, IOException {
//	File file = new File("D3_3499_퍼펙트셔플.txt");
//	BufferedReader br = new BufferedReader(new FileReader(file));
//	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//	int T = Integer.parseInt(br.readLine());
//	
//	for(int tc = 1; tc <= T; tc++) {
//		int N = Integer.parseInt(br.readLine());
//		
//		String[] arr = new String[N];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 1; i <= N; i++) {
//			if(i<=(N+1)/2) arr[(i-1)*2] = st.nextToken();
//			else arr[(i-(N+1)/2)*2-1] = st.nextToken();
//		}
//		
//		System.out.print("#" + tc);
//		for(int i = 0; i < N; i++) {
//			System.out.print(" " + arr[i]);
//		}
//		System.out.println();
//		
//	}
//}
