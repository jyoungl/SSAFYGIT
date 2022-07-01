import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1173_운동 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int time = 0;
		int health = m;
		
		if(m + T > M) {
			System.out.println(-1);
			return;
		}
		
		
		
		while(true) {
			
			if(health + T <= M) {
				health = health+T;
				cnt++;
			}else {
				health  = health - R;
				if(health < m) {
					health = m;
				}
			}
			
						
			time++;
			
			if(cnt == N) {
				break;
			}
		}
		
		System.out.println(time);
		
		
		

	}

}
