import java.io.*;
import java.util.*;

public class BOJ_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        boolean[] switches = new boolean[N];
        for(int i=0;i<N;i++) switches[i] = st.nextToken().equals("1");

        int number = Integer.parseInt(in.readLine());

        for(int i=0;i<number;i++){
            st = new StringTokenizer(in.readLine());
            String gender = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch(gender){
                case "1":
                    for(int j=num-1;j<N;j+=num) switches[j] = !switches[j];
                    break;
                case "2":
                    num -= 1;
                    switches[num] = !switches[num];
                    int idx = 1;
                    while(num-idx>=0 && num+idx<N && switches[num-idx]==switches[num+idx]){
                        switches[num-idx] = !switches[num-idx];
                        switches[num+idx] = !switches[num+idx];
                        ++idx;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(switches[i]) sb.append(1);
            else sb.append(0);
            sb.append(" ");

            if(i%20==19) sb.append("\n");
        }

        System.out.println(sb);
    }


}
