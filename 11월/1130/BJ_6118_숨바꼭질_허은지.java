import java.io.*;
import java.util.*;

/*
1. 입력 N과 M
2. A_i와 B_i
3. 숨어야 하는 헛간 번호 그 헛간까지의 거리 그 헛간과 같은 거리를 갖는 헛간의 개수
4. 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호 출력
 */
public class S1_6118_숨바꼭질 {
    static int num, min, cnt;
    static ArrayList[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        bfs(1);

        sb.append(num).append(" ").append(min).append(" ").append(cnt);

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치, 길이 저장
        queue.add(new int[] {start, 0});

        // 방문한 위치 저장
        visited[start] = true;

        // bfs
        while(!queue.isEmpty()) {
            int[] a = queue.poll();

            int now = a[0]; // 현재 위치
            int len = a[1]; // 다음 위치까지 갈 때 걸리는 총 거리

            if(len > min) { // 거리가 최소 거리보다 클 때
                min = len;  // 최소 거리 갱신
                num = now;  // 현재 위치 갱신
                cnt = 1;    // 같은 거리를 갖는 헛간의 개수 초기화
            } else if (len == min) {        // 거리가 최소 거리와 같을 때
                num = Math.min(num, now);   // 둘 중 숫자가 작은 헛간 저장
                cnt++;                      // 같은 거리를 갖는 헛간의 개수 초기화
            }

            for (int i = 0; i < map[now].size(); i++) {
                int next = (int) map[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(new int[] {next, len+1});
            }
        }
    }

}
