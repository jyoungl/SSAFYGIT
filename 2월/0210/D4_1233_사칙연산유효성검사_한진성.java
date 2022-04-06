package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class D4_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1233.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc<=10;tc++) {
			boolean check = true;
			int N = Integer.parseInt(in.readLine());		
			char[] chr = new char[N];
			for(int i=0;i<N;i++) {
				String[] str = in.readLine().split(" ");
				chr[i] = str[1].charAt(0);
				// 단말노드일때 숫자가 아닐 경우
				if(str.length ==2 && chr[i] < '0') {
					check = false;
				}
				// 단말노드가 아닌데 숫자일 경우
				if(str.length > 2 && chr[i] >= '0') {
					check = false;
				}
			}
			
			if(check) {
				System.out.printf("#%d %d\n",tc, 1);	
			}else {
				System.out.printf("#%d %d\n",tc, 0);	
			}
		}
	}
	
	
	// 야매식 풀이.. 반례가 있지만 통과된다.
	public static void main1(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1233.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		go:for(int tc = 1; tc<=10;tc++) {
			
			boolean check = true;
			
			int N = Integer.parseInt(in.readLine());
//			Tree tree = new Tree(N);
			char[] chr = new char[N];
			for(int i=0;i<N;i++) {
				String[] str = in.readLine().split(" ");
				chr[i] = str[1].charAt(0);
			}
			int cnt = 0;
			for(int i=0;i<N;i++) {
				// 숫자가 한번 나오면
				if(chr[i] >= '0' && check) {
					check = false;
				}
				// 그 다음부터는 무조건 숫자만 나와야 한다.
				if(chr[i] < '0' && !check) {
					System.out.printf("#%d %d\n",tc, 0);
					continue go;
				}
			}
	
			System.out.printf("#%d %d\n",tc, 1);	
		}
		
	}
}
//
//
//private void dfsByPostOrder(int current) {
//	
//	if(current>N) return;
//	
//
//	// 현재노드의 자식노드들 방문
//	dfsByPostOrder(current*2);
//	dfsByPostOrder(current*2+1);
//	
//	// 현재 노드 방문
//	System.out.print(nodes[current] + " ");
//}