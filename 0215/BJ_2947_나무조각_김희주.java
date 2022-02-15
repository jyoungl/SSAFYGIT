import java.io.*;
import java.util.*;

public class BOJ_2947_나무조각 {
    static List<Integer> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(Integer.parseInt(st.nextToken()));

        sb = new StringBuilder();

        for (int i = 0; ; i = (i + 1) % 5) {
            int ni = (i+1)%5;
            if(ni==0) continue;
            if (list.get(i) > list.get(ni)) {
                if (swap(i, ni)) break;
                else --i;
            }
        }

        System.out.print(sb.toString().trim());

    }

    private static boolean swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);

        boolean end = true;
        for (int k = 0; k < 5; k++) {
            sb.append(list.get(k)).append(" ");
            if (list.get(k) != k + 1) {
                end = false;
            }
        }

        sb.append("\n");
        return end;

    }
}
