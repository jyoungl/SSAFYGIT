package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 정수 K : 정수의 개수
 * K개의 줄에 정수 한개씩 주어짐
 * 정수가 0일 경우 최근에 있는 수 지움
 * 	>> stack.pop();
 */
public class lv18_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>(); //int형 스택 선언 
		int sum = 0;
		int sub = 0;
		
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) { //0을 입력했을 때
				sub += stack.pop(); // 가장 최근 수 지우고 빼는 수에 더함
			} else {
				stack.push(num); // 스택에 추가
				sum += num; // 추가되는 수 더함
			}
		}
		sum = sum - sub; //전체 합에서 지워진 수 빼기
		System.out.println(sum);
	}
}
