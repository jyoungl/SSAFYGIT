import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2307_일곱난쟁이 {
    static boolean[] find = new boolean[9];
    static int[] dwarfs = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(dwarfs);

        findDwarfs(0, 0, 0);

        for (int i = 0; i < 9; i++) {
            if (find[i]) System.out.println(dwarfs[i]);
        }

    }

    public static boolean findDwarfs(int idx, int count, int sum) {
        if (sum > 100) return false;
        if (count == 7 && sum == 100) return true;

        for(int i=idx;i<9;i++){
            find[i] = true;
            if(findDwarfs(i+1,count+1,sum+dwarfs[i])) return true;
            find[i] = false;
        }
        return false;
    }
}