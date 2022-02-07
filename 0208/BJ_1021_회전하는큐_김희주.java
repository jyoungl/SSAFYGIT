import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        st = new StringTokenizer(in.readLine());

        //탐색
        //오른쪽에서 뽑으면 +1 돼야 하는 걸 놓쳐서 자꾸 틀렸음(숫자는 항상 맨 앞에서 뽑기 때문)
        int sum = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            while (num != queue.peek()) {
                queue.offer(queue.poll());
                count++;
            }
            sum += Math.min(count, queue.size() - count);
            queue.poll();
        }

        //출력
        System.out.println(sum);
    }
}
