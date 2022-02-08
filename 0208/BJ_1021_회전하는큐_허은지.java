package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * .addFirst(1) : 1을 덱의 앞에 추가 push_front X
 * .addLast(1) : 1을 덱의 뒤에 push_back X
 * .removeFirst() : 반환하고 제거 pop_front(없으면 -1)
 * .removeLast() : 제거 pop_back (없으면 -1)
 * .size(): 크기 size
 * .isEmpty() : 비어 있는지 확인 empty(비어 있으면 1, 아니면 0)
 * .peekFirst() : 첫번째 값 참조 front (없으면 -1)
 * .peekLast() : 마지막 값 참조 back(없으면 -1)
 * 
 * 1. 큐의 크기 N, 뽑아내려고 하는 개수 M
 * 2. 뽑아내려고 하는 수의 위치
 * 3. add
 */
public class lv19_1021_회전하는큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();
		
		int result = 0;
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		} //덱 생성
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int count = 0;
			
			while(deque.peek()!=num) {//num이 나올 때까지 왼쪽으로 이동
				deque.add(deque.poll());
				count++;
			} 
			
			result += Math.min(count, deque.size()-count); //왼쪽 이동과 오른쪽 이동 중 최솟값 구하기
			
			deque.poll(); //원소 뽑기
		}
		System.out.println(result);	
	}
}
