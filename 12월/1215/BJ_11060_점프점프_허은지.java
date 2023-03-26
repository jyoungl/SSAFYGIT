import java.io.*;
import java.util.*;

public class S2_11060_점프점프 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[N+1];
        int[] DP = new int[N+1];
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
		}
        
        // 최솟값을 구해야 하기 때문에 DP 배열을 최댓값으로 채움
        Arrays.fill(DP, Integer.MAX_VALUE);
        // 첫 번째는 무조건 0부터 시작
        DP[1] = 0;
        
        for (int i = 1; i <= N; i++) {
        	// DP[i]가 최댓값이라면, 한 번도 방문한 적 없는 배열이라는 뜻이 된다 => 올 수 없음
        	if(DP[i] != Integer.MAX_VALUE) {
        		int jump = num[i];					// 점프할 수 있는 최대 칸 수
        		for (int j = 1; j <= jump; j++) {	// 1부터 최대 칸 수까지 전부 확인
        			// 만약 오른쪽 끝을 넘어가지 않았다면
        			//현재 점프(DP[i]+1)와 예전에 저장해 둔 점프 기록(DP[i+j]) 중 작은 것을 저장
					if(i + j <= N) DP[i+j] = Math.min(DP[i]+1, DP[i+j]);
				}
        	}
		}
        
        int min = -1;
        if(DP[N] != Integer.MAX_VALUE) min = DP[N];
        
        System.out.println(min);
    }

}
