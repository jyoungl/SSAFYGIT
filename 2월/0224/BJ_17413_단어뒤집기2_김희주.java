import java.io.*;
import java.util.*;

public class BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		String S = new BufferedReader(new InputStreamReader(System.in)).readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '<') {
				while (!stack.isEmpty()) sb.append(stack.pop());
				while (S.charAt(i) != '>') sb.append(S.charAt(i++));
				sb.append('>');
			} else if (S.charAt(i) == ' ') {
				while (!stack.isEmpty()) sb.append(stack.pop());
				sb.append(' ');
			} else {
				stack.push(S.charAt(i));
			}
		}
		while (!stack.isEmpty()) sb.append(stack.pop());
		System.out.println(sb);
	}
}