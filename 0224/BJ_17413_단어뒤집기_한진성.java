import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17413_단어뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] chars = in.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		boolean check = true;

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				check = false;
			}

			if (!check) {
				sb.append(chars[i]);
			} else {
				stack.push(chars[i]);
			}

			
			if (chars[i] == '>') {
				check = true;
			}

			if (chars[i] == ' ' && check) {
				stack.pop();
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
				
			} else if (i == chars.length - 1 && check) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}

		}

		System.out.println(sb);
	}

}
