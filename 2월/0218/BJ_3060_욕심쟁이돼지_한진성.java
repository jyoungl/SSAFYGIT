import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3060_욕심쟁이돼지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 0; tc<T;tc++) {
			
			long N = Integer.parseInt(in.readLine());
			
			
			long arr[] = new long[6];

			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int i=0;i<6;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			int cnt = 1;
			for(int i=0;i<6;i++) {
				sum = sum + arr[i];
			}
			
			if(sum > N) {
				System.out.println(cnt);
				continue;
			}
			while(true) {
				cnt++;
				sum = sum*4;
//				for(int i=0;i<6;i++) {
//					arr[i] = arr[i] + arr[(i+3)%6] + arr[(i+5)%6] + arr[(i+1)%6];
//					S = S - arr[i];
//				}
				if(sum > N) {
					break;
				}

				
			}
			
			System.out.println(cnt);
			
		}
		
		
	}

}
