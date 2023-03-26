import java.io.*;
import java.util.*;

public class G5_15486_퇴사2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        // i일째 구한 값을 i+1번째에 저장하기 때문에 N+1번째까지 있어야 함
        int[] DP = new int[N+2];
        
        int max = 0;
        
        for (int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	T[i] = Integer.parseInt(st.nextToken());
        	P[i] = Integer.parseInt(st.nextToken());
		}
        
        for (int i = 1; i <= N; i++) {
        	// 현재 가장 많이 받을 수 있는 돈은 오늘 끝나는 상담(이전에 DP[i+t[i]]로 넣어 뒀던 것)과 이전에 끝났던 상담(이전의 dp 값이 더 크다면 중간에 일을 쉬고 건너뜀) 중 큰 것
        	max = Math.max(DP[i], max);
        	// DP[i + T[i]] 지금 상담을 잡으면 T[i]일 뒤까지 예약이 잡히기 때문에 T[i]일 뒤에 받을 수 있는 돈을 지금 구할 수 있다
        	// 지금 예약을 잡는 것과(max + P[i]) 이전에 잡아 둔 예약 중(DP[i + T[i]) 더 큰 것을 T[i]일 뒤에(DP[i + T[i]]) 저장
        	if(i + T[i] <= N+1) DP[i + T[i]] = Math.max(DP[i + T[i]], max + P[i]);
		}
        
        max = Math.max(DP[N+1], max);
        
        System.out.println(max);
    }

}
