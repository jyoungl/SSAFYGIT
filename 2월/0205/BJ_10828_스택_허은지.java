package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * push(1) : 1추가
 * size() : 크기 출력
 * empty() : 비어 있는지 체크
 * pop() : 값 제거
 * peek() : 상단 값 출력
 * contains(1) : 1 있는지 확인
 * clear() : 초기화
 */
public class lv18_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수 N
		Stack<Integer> stack = new Stack<>(); //int형 스택 선언 
			
		for(int i = 0; i < N; i++) {
			String key = br.readLine();
			if (key.contains("push")) {
				String[] k = key.split(" ");
				int num = Integer.parseInt(k[1]);
				stack.push(num);
			} else if(key.equals("pop")) {
				try {
					System.out.println(stack.pop());
				} catch (EmptyStackException e) {
					System.out.println("-1");
				}
			} else if(key.equals("size")) {
				System.out.println(stack.size());
			} else if(key.equals("empty")) {
				if(stack.empty() == true) System.out.println("1");
				else System.out.println("0");
			} else if(key.equals("top")) {
				try {
					System.out.println(stack.peek());
				} catch (EmptyStackException e) {
					System.out.println("-1");
				}
			}
		}
		
	}
}
