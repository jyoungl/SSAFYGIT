import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] head = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=1;i<=N;i++) head[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            head[a].add(b);
            head[b].add(a);
        }

        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        queue.offer(new int[]{1,0});

        int[] node;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(visited[node[0]]) continue;
            visited[node[0]] = true;
            distance[node[0]] = node[1];

            for(int n:head[node[0]]){
                if(visited[n] || distance[n] <= node[1]+1) continue;
                distance[n] = node[1]+1;
                queue.offer(new int[]{n,distance[n]});
            }
        }

        int num = 1;
        int dist = distance[1];
        int cnt = 1;
        for(int i=2;i<=N;i++){
            if(dist<distance[i]){
                dist = distance[i];
                cnt = 1;
                num = i;
            }else if(dist == distance[i]){
                cnt++;
            }
        }

        System.out.println(num+" "+dist+" "+cnt);
    }
}