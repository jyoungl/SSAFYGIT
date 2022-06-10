import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1198_삼각형으로자르기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		
		int arr[][] = new int[N][2];
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(in.readLine());
			
			arr[i][0] =Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
						
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					
					if(i == j || j == k || k == i) continue;
					
					max = Math.max(max, Math.abs((arr[i][0]*arr[j][1] + arr[j][0]*arr[k][1] + arr[k][0]*arr[i][1]-
							(arr[i][1]*arr[j][0]+arr[j][1]*arr[k][0]+arr[k][1]*arr[i][0]))));
					
				}
			}
		}
		System.out.println(max/2.0);

	}

}
