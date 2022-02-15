import java.io.*;
import java.util.*;

public class BOJ_2527_직사각형 {
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(in.readLine());
            points = new int[8];
            for (int p = 0; p < 8; p++) points[p] = Integer.parseInt(st.nextToken());

            if (checkD()) sb.append("d");
            else if (checkC()) sb.append("c");
            else if (checkB()) sb.append("b");
            else sb.append("a");

            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean checkD() {
        if (points[0] > points[6]) return true;//점Ax1 > 점 Bx2
        if (points[2] < points[4]) return true;//점Ax2 < 점Bx1
        if (points[1] > points[7]) return true;//점Ay1 > 점 By2
        if (points[3] < points[5]) return true;//점Ay2 < 점By1

        return false;
    }

    private static boolean checkC() {
        if(points[0]==points[6] && points[1]==points[7]) return true;
        if(points[0]==points[6] && points[3]==points[5]) return true;
        if(points[2]==points[4] && points[3]==points[5]) return true;
        if(points[2]==points[4] && points[1]==points[7]) return true;

        return false;
    }

    private static boolean checkB() {
        if (points[0] == points[6]) return true;
        if (points[2] == points[4]) return true;
        if (points[1] == points[7]) return true;
        if (points[3] == points[5]) return true;

        return false;
    }
}
