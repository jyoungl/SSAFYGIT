import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
		
		public static void main(String[] args) throws NumberFormatException, IOException {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int E = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int i = 1;
			int j = 1;
			int k = 1;
			int cnt = 0;
			while(true) {
				cnt++;
				if(E==i && S==j && M==k) {
					break;
				}
				
				i++;
				j++;
				k++;
				
				if(i == 16) {
					i=1;
				}
				if(j == 29) {
					j=1;
				}
				if(k == 20) {
					k=1;
				}
				
			}
			System.out.println(cnt);
	}

}
