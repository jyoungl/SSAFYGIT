import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040_일곱난쟁이 {
    static int[] dwarfs = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int sum = -100;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(in.readLine());
            sum += dwarfs[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum == dwarfs[i] + dwarfs[j]) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) System.out.println(dwarfs[k]);
                    }
                    break;
                }
            }
        }


    }
}