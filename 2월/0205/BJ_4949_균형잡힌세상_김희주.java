import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = in.readLine();
            if (line.equals(".")) break;

            stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch != '(' && ch != '[' && ch != ')' && ch != ']') continue;

                if (ch == '(' || ch == '[') stack.push(ch);
                else if (stack.empty()) {
                    stack.push('*');    //체크위해서 넣어둠
                    break;
                } else if (ch == ')' && stack.peek() == '(') stack.pop();
                else if (ch == ']' && stack.peek() == '[') stack.pop();
                else break;
            }

            if (stack.empty()) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.print(sb);
    }
}
