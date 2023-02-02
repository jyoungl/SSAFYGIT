import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1963_소수경로_이주영 {
    public static boolean[] prime = new boolean[10000];
    public static int[] cnt;
    public static boolean[] visited;
    public static int[] d = {1000,100,10,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        elatos();

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cnt = new int[10000];
            visited = new boolean[10000];
            bfs(x,y);
            sb.append(cnt[y] +"\n");
        }
        System.out.println(sb);
    }

    public static void elatos(){
        prime[0] = prime[1] = true;
        for(int i=2;i<10000;i++){
            if(!prime[i]){
                for(int j=i+i;j<10000;j+=i){
                    prime[j] = true;
                }
            }
        }
    }

    public static void bfs(int s, int e){
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        visited[s] = true;

        while(!que.isEmpty()){
            int now = que.poll();

            if(now == e)
                return;

            for(int i=0;i<4;i++){
                int x = now/d[i]/10;
                int y = now % d[i];

                for(int j=0;j<=9;j++){
                    if(i == 0 && j == 0)
                        continue;

                    int num = (x*d[i]*10) + (j*d[i]) + y;
                    if(!prime[num] && !visited[num]){
                        que.add(num);
                        visited[num] = true;
                        cnt[num] = cnt[now] + 1;
                    }
                }
            }
        }
    }
}
