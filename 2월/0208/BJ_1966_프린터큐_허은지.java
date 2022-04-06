package silver3;

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
 * 1. T 테스트 케이스
 * 2. 문서의 개수 N 구하려고 하는 문서 M(중요도가 클수록 빨리 출력)
 * 3. 중요도(1~9)
 * 
 * >> 중요도가 더 높은 문서가 하나라도 있다면 queue의 가장 뒤에 재배치 그렇지 않다면 바로 인쇄
 * >> 큐에 int[] 순서와 함께 삽입
 * >> 중요도 순서대로 배열 정렬
 */
public class lv19_1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>(); //배열을 담은 큐
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken()); //중요도
				queue.add(new int[] {i, num}); //문서(M)와 중요도
			} //큐 삽입

			int count = 0;
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				max = Math.max(queue.peek()[1], max);
				queue.add(queue.poll());
			} //가장 큰 중요도 max에 저장
			
			while(!queue.isEmpty()) { //비어 있지 않고
				
				if(queue.peek()[1] < max) { //peek가 max보다 작으면
					queue.add(queue.poll()); // 뒤로 보내기
				} else { //작지 않으면 바로 출력 => M과 같으면 몇 번째인지 출력
					count++;
					if(queue.peek()[0]==M) { //M과 같으면
						System.out.println(count);
						break; //순서를 출력한 뒤 break;
					}
					queue.poll();
					max = 0;
					for(int i = 0; i < N-count; i++) {
						max = Math.max(queue.peek()[1], max);
						queue.add(queue.poll());	
					} //다음으로 큰 중요도 max에 저장
				}
			}
		}
	}
}
