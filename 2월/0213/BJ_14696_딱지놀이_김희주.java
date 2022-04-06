import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//이렇게 정렬 안하고 a b 각각 4칸짜리 배열 만들어서 숫자 세도 ㅇㅋ....ㅜㅜ
public class BOJ_14696_딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        int a,b;
        Integer[] aCard, bCard;
        boolean win;

        for(int n=0;n<N;n++){
            win = false;

            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            aCard = new Integer[a];
            for(int i=0;i<a;i++) aCard[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            b = Integer.parseInt(st.nextToken());
            bCard = new Integer[b];
            for(int i=0;i<b;i++) bCard[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(aCard, Collections.reverseOrder());
            Arrays.sort(bCard, Collections.reverseOrder());

            for(int i=0;i<Math.min(a,b);i++){
                if(aCard[i]>bCard[i]) {
                    win = true;
                    sb.append("A\n");
                    break;
                }
                else if(aCard[i]<bCard[i]) {
                    win = true;
                    sb.append("B\n");
                    break;
                }
            }

            if(win) continue;

            if(a>b) sb.append("A\n");
            else if(b>a) sb.append("B\n");
            else sb.append("D\n");

        }

        System.out.print(sb);
    }
}
