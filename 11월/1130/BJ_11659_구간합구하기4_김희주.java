import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];

        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=N;i++){
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }
        int first, second;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            sb.append(sum[second]-sum[first-1]).append("\n");
        }

        System.out.print(sb);
    }
}