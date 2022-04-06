import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(N-->0){
            st = new StringTokenizer(in.readLine());
            switch(st.nextToken()){
                case "pop":
                    if(!stack.empty()) sb.append(stack.pop());
                    else sb.append(-1);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.empty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case "top":
                    if(!stack.empty()) sb.append(stack.peek());
                    else sb.append(-1);
                    sb.append("\n");
                    break;
                default:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
            }
        }

        System.out.println(sb);
    }
}
