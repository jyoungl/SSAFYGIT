import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            //입력
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            int[] nums = new int[N];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                queue.offer(nums[i]);
            }

            Arrays.sort(nums);

            //탐색
            int idx = M;
            int order = 0;
            for (int i = N - 1; i >= 0; i--) {
                while (nums[i] != queue.peek()) {
                    queue.offer(queue.poll());
                    idx = idx == 0 ? queue.size()-1 : --idx;
                }

                queue.poll();
                order++;

                if (idx == 0) {
                    sb.append(order).append("\n");
                    break;
                }else{
                    idx--;
                }
            }
        }

        System.out.print(sb);
    }
}