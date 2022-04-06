import java.io.*;
import java.util.*;

public class BOJ_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

        int MAX = Integer.MIN_VALUE;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int n=0;n<N;n++) {
            int num = Integer.parseInt(st.nextToken());
            queue.offer(num);
            sum += num;
            if(queue.size()==K) {
                MAX = Math.max(MAX,sum);
                sum -= queue.poll();
            }
        }

        System.out.println(MAX);
    }
}
