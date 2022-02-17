import java.io.*;
import java.util.*;

public class BOJ_3060_욕심쟁이돼지 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int tc=0;tc<T;tc++){
            int N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());

            int day = 1;
            long sum = 0;

            for(int i=0;i<6;i++) sum += Integer.parseInt(st.nextToken());


            while(sum<=N) {
                sum *= 4;
                ++day;
            }


            sb.append(day).append("\n");
        }

        System.out.print(sb);
    }
}
