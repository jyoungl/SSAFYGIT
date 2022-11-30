import java.util.*;
import java.io.*;

public class Main {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        for(int i=1;i<=N;i++) set[i] = i;
        StringBuilder sb = new StringBuilder();
        boolean command;
        int a,b;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            command = st.nextToken().equals("0");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(command){
                union(a,b);
            }else if(find(a)==find(b)){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
    public static int find(int x){
        if(set[x]==x) return x;
        return set[x] = find(set[x]);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) set[pb] = pa;
    }
}