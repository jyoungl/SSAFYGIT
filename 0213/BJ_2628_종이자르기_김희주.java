import java.io.*;
import java.util.*;

public class BOJ_2628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(in.readLine());

        int[][] lines = new int[N + 2][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        lines[N] = new int[]{1, width};
        lines[N + 1] = new int[]{0, height};

        Arrays.sort(lines, (o1, o2) -> o1[1] - o2[1]);

        int maxArea = 0;
        int prevW = 0, prevH;

        for (int i = 0; i < N + 2; i++) {
            if (lines[i][0] != 0) continue;
            int gapW = lines[i][1] - prevW;

            prevH = 0;

            for (int j = 0; j < N + 2; j++) {
                if (lines[j][0] != 1) continue;

                int area = gapW * (lines[j][1] - prevH);
                maxArea = Math.max(maxArea, area);
                prevH = lines[j][1];
            }

            prevW = lines[i][1];

        }

        System.out.println(maxArea);

    }
}
