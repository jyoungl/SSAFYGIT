import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796_캠핑 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;
		while(true) {
	
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			
			int P = Integer.parseInt(st.nextToken());
			
			int V = Integer.parseInt(st.nextToken());
			
			if(L == 0 && P == 0 && V == 0) {
				break;
			}
			int sum = 0;
			while(true) {
				V = V-P;
				sum = sum + L;
				
				if(V-P < 0) {
					
					if(V < L) {					
						sum = sum + V;
					}else {
						sum = sum + L;
					}
					break;
				}
				
			}
			
			
			System.out.println("Case "+i+": "+sum);
			i++;
		}
		
	}

}
