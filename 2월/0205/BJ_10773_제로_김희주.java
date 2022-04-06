import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(in.readLine());

        Stack<Integer> stack = new Stack<>();
        while(K-->0){
            int num = Integer.parseInt(in.readLine());
            if(num==0) stack.pop();
            else stack.push(num);
        }

        System.out.println(stack.stream().mapToInt(i->i).sum());
    }
}
