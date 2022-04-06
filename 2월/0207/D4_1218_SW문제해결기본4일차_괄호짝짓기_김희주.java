import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218_SW문제해결기본4일차_괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        
        for(int tc=1;tc<=10;tc++) {
        	sb.append("#").append(tc).append(" ");
        	
        	int len = Integer.parseInt(in.readLine());
        	String line = in.readLine();
            stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                char ch = line.charAt(i);

                if (ch != '(' && ch != ')' && ch != '[' && ch != ']' && ch !='{' && ch != '}' && ch!='<' && ch != '>') continue;

                if (ch == '(' || ch == '[' || ch=='{' || ch=='<')  stack.push(ch);
                else if (stack.empty()) {
                    stack.push('*');    //체크위해서 넣어둠
                    break;
                } else if (ch == ')' && stack.peek() == '(') stack.pop();
                else if (ch == ']' && stack.peek() == '[') stack.pop();
                else if (ch == '}' && stack.peek() == '{') stack.pop();
                else if (ch == '>' && stack.peek() == '<') stack.pop();
                else break;
            }

            if (stack.empty()) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
	}
}
