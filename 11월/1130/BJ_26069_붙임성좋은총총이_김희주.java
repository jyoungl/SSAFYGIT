import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Map<String,Boolean> map = new HashMap<>();
        map.put("ChongChong",true);

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(map.getOrDefault(a,false) || map.getOrDefault(b,false)){
                map.put(a,true);
                map.put(b,true);
            }
        }

        System.out.println(map.size());
    }
}
