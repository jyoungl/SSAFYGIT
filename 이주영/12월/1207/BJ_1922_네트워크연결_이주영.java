import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1922_네트워크연결_이주영 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N+1];
        int ans = 0;
        int[][] arr = new int[M][3];
        for(int i=0;i<=N;i++)
            parent[i] = i;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //연결1
            arr[i][1] = Integer.parseInt(st.nextToken()); //연결2
            arr[i][2] = Integer.parseInt(st.nextToken()); //비용
        }
        Arrays.sort(arr, Comparator.comparingInt(o->o[2]));
        //비용 낮은 순으로 정렬
        for(int[] a : arr){
            if(union(a[0], a[1])) //연결했으면
                ans += a[2];
        }
        System.out.println(ans);
    }
    static int find(int x){
        if(parent[x] == x)
            return x;
        else return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) {
            parent[y] = x;
            return true;
        }

        return false;
    }
}
