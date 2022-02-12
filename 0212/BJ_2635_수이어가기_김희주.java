import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1. 양의 정수에 0이 포함됨(왜???? 어이없어)
//2. 두번째 수도 N과 같을 수 있음
public class BOJ_2635_수이어가기 {
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int maxLen = 1;
        int maxSecond = N;

        int first, second;
        for (int num = N; num >= 0; num--) {
            first = N;
            second = num;
            int cnt = 2;

            while (first - second >= 0) {
                int third = first - second;
                first = second;
                second = third;
                cnt++;
            }

            if (maxLen < cnt) {
                maxLen = cnt;
                maxSecond = num;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append("\n");
        sb.append(N).append(" ").append(maxSecond).append(" ");

        first = N;
        while (first - maxSecond >= 0) {
            int third = first - maxSecond;
            first = maxSecond;
            maxSecond = third;

            sb.append(maxSecond).append(" ");
        }

        System.out.println(sb);
    }
}
