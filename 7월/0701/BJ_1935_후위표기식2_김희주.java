import java.io.*;
import java.util.*;

public class BOJ_1935_후위표기식2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[26];
		int N = Integer.parseInt(in.readLine());
		char[] input = in.readLine().toCharArray();
		for(int i=0;i<N;i++) num[i] = Integer.parseInt(in.readLine());

		Stack<Double> stack = new Stack<>();
		for(int i=0;i<input.length;i++){
			if(input[i]>='A' && input[i]<='Z'){
				stack.push((double) num[input[i]-'A']);
			}else{
				switch(input[i]){
					case '*':
						stack.push(stack.pop()*stack.pop());
						break;
					case '/':
						stack.push((1/stack.pop())*stack.pop());
						break;
					case '+':
						stack.push(stack.pop()+stack.pop());
						break;
					case '-':
						stack.push(-stack.pop()+stack.pop());
						break;
				}
			}
		}
		System.out.printf("%.2f",stack.pop());
	}
}
