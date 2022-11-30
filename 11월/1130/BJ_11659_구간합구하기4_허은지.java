import java.io.*;
import java.util.*;

/*
1. 수의 개수 N 합을 구해야 하는 횟수 M
2. N개의 수
3. 합을 구해야 하는 구간 i와 j
 */
public class S3_11659_구간합구하기4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum[b]-sum[a-1] + "\n");
        }

        System.out.println(sb);
    }

}
