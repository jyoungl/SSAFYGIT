import java.io.*;
import java.util.*;

public class BJ_1963_소수경로 {
	static boolean[] prime = new boolean[10000];
	public static void main(String[] args) throws IOException {
		initPrime();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-->0){
			st = new StringTokenizer(in.readLine());
			int result = solve(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			if(result<0) sb.append("Impossible\n");
			else sb.append(result).append('\n');
		}

		System.out.print(sb);
	}

	private static void initPrime(){
		//소수이면 false
		prime[0] = prime[1] = true;
		for(int i=2;i<10000;i++){
			if(prime[i]) continue;
			for(int j=i*2;j<10000;j+=i){
				prime[j] = true;
			}
		}
	}

	private static int solve(int a, int b){
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[10000];
		queue.offer(new int[]{a,0});

		int[] now;
		int num;
		int[] numAr = new int[4];
		while(!queue.isEmpty()){
			now = queue.poll();
			num = now[0];
			if(visited[num]) continue;
			visited[num] = true;

			if(now[0]==b){
				//끝나는 조건
				return now[1];
			}

			//숫자 해체
			for(int i=0;i<4;i++) {
				numAr[i] = num%10;
				num/=10;
			}

			for(int i=0;i<4;i++){
				for(int j=0;j<10;j++){
					if(i==3 && j==0) continue;//천의자리는 0이면 안됨
					if(numAr[i]==j) continue;//원래 수와 동일하면 안됨
					int next = (int) (now[0]-(numAr[i]-j)*Math.pow(10,i));
					//소수이고 방문한 적 없어야함
					if(!prime[next] && !visited[next]) queue.offer(new int[]{next,now[1]+1});
				}
			}
		}

		return -1;
	}
}
