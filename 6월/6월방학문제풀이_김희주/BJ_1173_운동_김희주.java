import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1173_운동 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		if(m+T>M){
			System.out.println(-1);
			return;
		}

		int X = m;
		int time = 0;
		while(N>0){
			if(X+T<=M) {
				X+=T;
				N--;
			}
			else {
				X = Math.max(X-R,m);
			}
			time++;
		}

		System.out.println(time);
	}
}
