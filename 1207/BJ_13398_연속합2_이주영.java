import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13398_연속합2_이주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = dp[0][1] = arr[0];
        int ans = arr[0];
        //dp[x][0] -> 제거 한 번도 안하고 연속합 더한 경우
        //dp[x][1] -> 어떤 수를 한 번 제거하고 연속한 구한 경우
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            //숫자 하나도 안 뺀 경우의 합: 이전까지 합[0] + 이번 수 / 이번부터 연속합 시작
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
            //숫자 한 번 빼먹은 경우: 이번 수 뺌 / 이전에 수 한개뺌 + 이번 수 더함

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
    }
}
