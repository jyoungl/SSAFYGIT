package feb20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5904_Moo게임_이주영 {
    static String answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        make(N);
        System.out.println(answer);

        //1 4 8 11 16 19 23
        //3 4 3 5 3 4 3
    }

    public static void make(int cnt) {
        int len = 3;
        int k = 0;

        if(cnt == 1)
            answer = "m";
        else if(cnt<=3)
            answer = "o";
        else {
            while (len < cnt) {
                len = (len * 2 + k + 4);
                k++;
            }
            int idx = (len - k - 3) / 2;

            if (len-idx+1 <= cnt) {
                make(cnt-len+idx);
            }
            else if(cnt == idx+1){
                answer = "m";
            }
            else
                answer = "o";
        }

    }
}
