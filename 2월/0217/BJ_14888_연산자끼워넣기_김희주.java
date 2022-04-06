import java.io.*;
import java.util.*;

public class BOJ_14888_연산자끼워넣기 {
    static int[] oCnt = new int[4];//덧셈, 뺄셈, 곱셈, 나눗셈 개수
    static int N;
    static int[] operator, numbers;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        numbers = new int[N];
        operator = new int[N - 1];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) oCnt[i] = Integer.parseInt(st.nextToken());

        insert(0);

        System.out.println(max);
        System.out.println(min);

    }

    private static void insert(int cnt) {
        if (cnt == N - 1) {
            int result = calc();
            if (max < result) max = result;
            if (min > result) min = result;
            return;
        }

        for(int i=0;i<4;i++){
            if(oCnt[i]==0) continue;
            --oCnt[i];
            operator[cnt] = i;
            insert(cnt+1);
            ++oCnt[i];
        }
    }

    private static int calc() {
        int result = numbers[0];
        for (int i = 1; i < N; i++) {
            int num = numbers[i];
            switch (operator[i - 1]) {
                case 0:
                    result += num;
                    break;
                case 1:
                    result -= num;
                    break;
                case 2:
                    result *= num;
                    break;
                case 3:
                    result /= num;
                    break;
            }
        }

        return result;
    }
}
