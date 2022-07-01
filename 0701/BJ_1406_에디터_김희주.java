import java.io.*;
import java.util.*;

public class BOJ_1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = in.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		Stack<Character> res = new Stack<>();
		for(int i=0;i<input.length;i++) stack.push(input[i]);
		int M = Integer.parseInt(in.readLine());
		String command;
		for(int i=0;i<M;i++){
			command = in.readLine();
			switch(command.charAt(0)){
				case 'P':
					stack.push(command.charAt(2));
					break;
				case 'L':
					if(!stack.empty()) res.push(stack.pop());
					break;
				case 'D':
					if(!res.empty()) stack.push(res.pop());
					break;
				case 'B':
					if(!stack.empty()) stack.pop();
					break;
			}
		}
		while(!stack.empty()) res.push(stack.pop());
		while(!res.empty()) out.write(res.pop());
		out.flush();
		out.close();
	}
}
