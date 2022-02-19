package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 바퀴의 칸 수 N 바퀴를 돌리는 횟수 K
 * 2. 화살표를 가리키는 글자가 몇 번 바뀌었는지 나타내는 S 마지막에 가리키던 글자 A
 * 
 * 출력
 * 바퀴판에 적힌 글자 출력
 * 해당 자리를 결정하지 못하면 ?
 * 행운의 바퀴가 존재하지 못할 시 !
 * 
 * >> 큐를 사용??
 * >> 배열 사용
 */
public class s4_2840_행운의바퀴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] wheel = new char[N];
		int num = 0;
		
		for(int i = 0; i<N; i++) {
			wheel[i] = '?';
		}
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			char word = st.nextToken().charAt(0);
			num += S;

			if(wheel[num%N] == '?') wheel[num%N] = word;
			else if(wheel[num%N]!=word) {
				System.out.println("!");
				System.exit(0);
			}
			wheel[num%N] = word;
			
			
		}
		
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(wheel[i] != '?' && wheel[i] == wheel[j]) {
					System.out.println("!");
					System.exit(0);
				}
			}
		}
		
		
		for(int i = 0; i<N; i++) {
			sb.append(wheel[(num-i)%N]);
		}
		
		System.out.println(sb);
		
	}

}
