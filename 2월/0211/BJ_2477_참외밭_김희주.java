import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] points = new int[6][2];

        int carrot = Integer.parseInt(in.readLine());
        StringTokenizer st;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(in.readLine());
            points[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int X, Y;

        int[] prev1 = points[0];
        int[] prev2 = points[1];

        int idx = 2;
        while (true) {
            int nidx = (idx + 1) % 6;
            if (points[idx][0] == prev1[0] && points[nidx][0] == prev2[0]) {
                X = points[(nidx+1)%6][1];
                Y = points[(nidx+2)%6][1];
                break;
            }

            prev1 = prev2;
            prev2 = points[idx];
            idx = nidx;
        }

        int innerX = points[idx][1];
        int innerY = prev2[1];

        int result = (X*Y - innerX * innerY) * carrot;

        System.out.println(result);

    }
}
