package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * .add(1) : 1 추가(공간이 없으면 exception 반환)
 * .offer(1) : 1 추가
 * .poll() : 반환하고 제거
 * .remove() : 제거
 * .clear() : 초기화
 * .peek() : 첫번째 값 참조
 * .peekLast() : 마지막 값 참조 >> Deque
 * 
 * >> 정수 N개의 카드 1234N
 * >> 제일 윗장 poll 한 뒤 그 다음장 add(poll)
 */
public class lv19_2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
			
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		} //큐 삽입
		while(queue.size() != 1) { //한장 남을때까지
			queue.poll(); //제일 윗장 버리고
			queue.add(queue.poll()); //그 다음장 마지막으로 보낸다
		}
		System.out.println(queue.peek());
	}
}
