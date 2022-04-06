import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2564_경비원 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int total = (width + height) << 1;

        int N = Integer.parseInt(in.readLine());

        //직선으로 만들기 - 시계방향 주의!
        //북쪽은 그냥 넣기
        //동쪽은 북쪽너비+동쪽
        //남쪽은 북쪽너비+동쪽높이+(남쪽너비-남쪽)
        //서쪽은 북쪽너비+동쪽높이+남쪽너비+(서쪽너비-서쪽)

        //마지막 방은 동근이 위치
        int[] spots = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            int way = Integer.parseInt(st.nextToken());
            spots[i] = Integer.parseInt(st.nextToken());

            if (way == 2) spots[i] = width - spots[i];
            else if (way == 3) spots[i] = height - spots[i];

            switch (way) {
                case 3: spots[i] += width;
                case 2: spots[i] += height;
                case 4: spots[i] += width;
            }
        }

        //상점-동근위치 빼고, 그 길이와 토탈-길이 비교하기!
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int len = Math.abs(spots[N] - spots[i]);
            sum += Math.min(len, total - len);
        }

        System.out.println(sum);
    }
}
