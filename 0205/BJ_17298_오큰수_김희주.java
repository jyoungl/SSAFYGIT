import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        //입력
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //탐색
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                result[i] = -1;
            } else if (stack.peek() > nums[i]) {
                result[i] = stack.peek();
            }

            stack.push(nums[i]);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }


        System.out.println(sb);
    }
}
