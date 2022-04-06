import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(in.readLine());
            while (true) {
                if (num >= count) {
                    stack.push(count++);
                    sb.append("+\n");
                }

                if (stack.empty() || num < stack.peek()) {
                    System.out.println("NO");
                    return;
                } else if (num == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                    break;
                }
            }
        }
        System.out.print(sb);

    }
}
