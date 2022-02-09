package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1. 학생의 수 N
 * 2. 줄을 선 차례대로 학생들이 뽑은 숫자
 * 3. 뽑은 수만큼 앞자리로 가서 줄을 선다
 * 
 * >> stack 사용 XX >> Deque 사용
 * >> 뽑은 숫자만큼 pop한 뒤 다시 넣기
 */
public class b2_2605_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==0) deq.addLast(i);
			else {
				for(int j = 0; j<num; j++) {
					deq.addFirst(deq.pollLast());
				}
				deq.addLast(i);
				for(int j = 0; j<num; j++) {
					deq.addLast(deq.pollFirst());
				}
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(deq.poll() + " ");
		}
	}
}
