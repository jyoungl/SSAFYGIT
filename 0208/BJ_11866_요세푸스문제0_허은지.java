package silver4;

import java.io.BufferedReader;
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
 * .peekLast() : 마지막 값 참조 >> Deque
 * 
 * 1. N K => N명의 사람이 앉아 있고 K번째 사람이 제거된다 한 명이 남을 때까지 반복한 뒤 마지막에 한 명 출력
 * 2. 출력 sb.append < , , , , , , >
 * 
 * >> K-1까지 add(poll) K번째 poll
 */
public class lv19_11866_요세푸스문제0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
			
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		} //큐 삽입
		
		sb.append("<");
		
		while(queue.size() != 1) { //한명 남을때까지
			for(int i = 0; i < K-1; i++) {
				queue.add(queue.poll()); //앞에 있는 사람은 뒤로 보냄
			}
			sb.append(queue.poll() + ", ");
		}
		
		sb.append(queue.poll() + ">"); //마지막 숫자
		
		System.out.println(sb);
	}
}
