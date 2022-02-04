import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        Stack<Character> stack;

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            stack = new Stack<>();
            String line = in.readLine();

            for(int i=0;i<line.length();i++){
                if(line.charAt(i)=='(') stack.push('(');
                else if(!stack.empty() && stack.peek()=='(') stack.pop();
                else if(stack.empty()) {
                    stack.push('*');    //체크위해서 넣어둠
                    break;
                }
            }

            if(stack.empty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }
}