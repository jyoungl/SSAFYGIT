import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			//입력
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());//과자봉지개수
			int M = Integer.parseInt(st.nextToken());//무게합 제한
			
			st = new StringTokenizer(in.readLine());
			
			int[] snacks = new int[N];
			for(int i=0;i<N;i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			//탐색
			int max = -1;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					int tmp = snacks[i]+snacks[j];
					if(max<tmp && tmp<=M) max = tmp;
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
}
