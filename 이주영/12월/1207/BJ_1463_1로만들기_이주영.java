import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 0;
        if(N>=2)
            dp[2] = 1;

        for(int i=3;i<=N;i++){
            if(i%6 == 0) {
                dp[i] = 1 + Math.min(dp[i/3], Math.min(dp[i/2], dp[i-1]));
            }
            else if(i%2 == 0) {
                dp[i] = 1 + Math.min(dp[i/2], dp[i-1]);
            }
            else if(i%3 == 0) {
                dp[i] = 1 + Math.min(dp[i/3], dp[i-1]);
            }

            else {
                dp[i] = 1 + dp[i-1];
            }
        }

        System.out.println(dp[N]);
    }
}
