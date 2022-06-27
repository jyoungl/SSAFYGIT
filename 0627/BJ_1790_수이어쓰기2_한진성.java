import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790_수이어쓰기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int term = 1;
		int cnt= 1;
		for(int i=1;i<=N;i++) {	
			switch(i) {
			case 10:
				term++;
				break;
			case 100:
				term++;
				break;
			case 1000:
				term++;
				break;
			case 10000:
				term++;
				break;
			case 100000:
				term++;
				break;
			case 1000000:
				term++;
				break;
			case 10000000:
				term++;
				break;
			case 100000000:
				term++;
				break;		
			}
//			System.out.print(i);
			cnt += term;
			
			if(cnt > K) {
//				System.out.println();
				String str = String.valueOf(i);
				int point = term;
				
				while(cnt != K) {
					cnt--;
					point--;
				}
				
				System.out.println(str.charAt(point));
				return;
			}
		}
		
		System.out.println(-1);
	}

}
