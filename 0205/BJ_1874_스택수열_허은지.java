import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class lv18_1874_스택수열 {

	/*
	 * 1. 첫줄 N은 수열의 크기
	 * 2. 다음 줄부터 1~N까지 숫자가 랜덤으로 나옴 => 만들고 싶은 수열
	 * 3. 1~N까지 차례로 스택에 넣었다 빼면서 2와 같은 수열을 만듦
	 * 4. 만들 수 없으면 NO 출력
	 * 
	 * >> 숫자를 더 작은 쪽으로는 건너뛸 수 없음
	 * >> 쌓은 뒤 peek이 주어진 숫자와 같으면 pop 작으면 push 크면 NO
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //수열의 크기
		Stack<Integer> stack = new Stack<>();
		int n = 1; //스택에 들어가는 숫자 1부터 시작
		StringBuilder sb = new StringBuilder(); //저장한뒤 출력해야 하기 때문에 사용
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(stack.empty() == true) { //공백일때
				stack.push(n); //스택 쌓기
				n++;
				sb.append('+').append('\n');
			}
			while(num > stack.peek()) { //peek이 작으면 같아질 때까지 push
				stack.push(n);
				n++;
				sb.append('+').append('\n');
			}
			if (num == stack.peek()) { //같으면 pop
				stack.pop();
				sb.append('-').append('\n');
			} else { //peek이 크면 no
				System.out.println("NO"); 
				System.exit(0); //NO가 뜨면 종료
			}
		}
		System.out.println(sb);
	}
}
