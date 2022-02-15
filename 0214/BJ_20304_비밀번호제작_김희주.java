import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20304_비밀번호제작 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        int[] password = new int[1000001];//0 버리고 100만개
        Arrays.fill(password, -1);
        Queue<Integer> queue = new LinkedList<>();

        //비밀번호, depth 각각 큐와 배열에 넣기
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int m = 0; m < M; m++) {
            int num = Integer.parseInt(st.nextToken());
            password[num] = 0;
            queue.offer(num);
        }

        int MAX = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            //큐에서 뽑아낸 숫자와 비교
            //1을 <<해서 000000...01, 00000,,,10, 이런 식으로 하나씩 비교한다.
            //그렇게 구한 값이 N보다 크거나 이미 구한 수라면 다음 수랑 비교한다.
            //패스워드 depth저장하는 배열에 이전수+1값을 넣고
            //큐에 다시 비교한 수를 넣는다.
            for (int i = 0; i < 20; i++) {
                int next = num ^ (1 << i);
                if (next > N || password[next] != -1) continue;
                password[next] = password[num] + 1;
                queue.offer(next);

            }
            MAX = Math.max(MAX, password[num]);
        }

        //Integer.bitCount(1000) --> 1개수 리턴

        System.out.println(MAX);
    }
}
