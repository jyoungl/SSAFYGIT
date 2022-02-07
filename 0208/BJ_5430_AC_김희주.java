import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-->0) {
            //입력
            String P = in.readLine();
            int N = Integer.parseInt(in.readLine());

            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(in.readLine(), "[|]|,");
            while (st.hasMoreTokens()) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            //탐색
            boolean isR = true;
            boolean error = false;
            for (int i = 0; i < P.length(); i++) {
                if (error) break;
                switch (P.charAt(i)) {
                    case 'R':
                        isR = !isR;
                        break;
                    case 'D':
                        if (deque.isEmpty()) error = true;
                        else if (isR) deque.poll();
                        else deque.pollLast();
                        break;
                }
            }

            //출력
            if(error) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            while(!deque.isEmpty()) {
                if (isR) sb.append(deque.poll());
                else sb.append(deque.pollLast());
                if(deque.size()>=1) sb.append(",");
            }
            sb.append("]\n");

        }

        System.out.print(sb);
    }
}
