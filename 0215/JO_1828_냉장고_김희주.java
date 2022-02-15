import java.io.*;
import java.util.*;

public class JO_1828_냉장고{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        //최소값 기준으로 정렬. 만약 같다면 최대값 기준으로.
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1,o2)->o1[0]==o2[0]? o1[1]-o2[1]:o1[0]-o2[0]);

        for(int n=0;n<N;n++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            pQueue.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        //만약 이전 재료의 최대값이 지금 재료의 최소값보다 크다면 겹치는 것
        //그럼 겹친 만큼을 다시 기준 범위로 삼음
        //큐를 다 비우면 끝
        int cnt = N;
        int[] prev = pQueue.poll();
        while(!pQueue.isEmpty()){
            int[] cur = pQueue.poll();
            if(prev[1]>=cur[0]){
                --cnt;
                prev = new int[]{cur[0],Math.min(prev[1],cur[1])};
            }else{
                prev = cur;
            }
        }

        System.out.println(cnt);
    }
}
