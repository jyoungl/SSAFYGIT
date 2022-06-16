import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		char[] arr = in.readLine().toCharArray();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == '(') {
				stack.push(i);
			}else {
				if(stack.peek()+1 == i) {
					stack.pop();
					cnt += stack.size();
				}else {
					stack.pop();
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
