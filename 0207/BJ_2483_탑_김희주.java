import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] top = new int[N];

        for(int i=0;i<N;i++){
            top[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        //탐색
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            while(!stack.empty() && top[stack.peek()]<top[i]){
                stack.pop();
            }

            if(stack.empty()) sb.append("0 ");
            else sb.append(stack.peek()+1).append(" ");

            stack.push(i);
        }

        //출력
        System.out.println(sb);
    }
}
