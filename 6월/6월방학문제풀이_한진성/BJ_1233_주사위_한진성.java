import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1233_주사위 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		
		int B = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[A+B+C+1];
		int cnt = 0;
		for(int i=1;i<=A;i++) {
			for(int j=1;j<=B;j++) {
				for(int k=1;k<=C;k++) {
//					System.out.println(i+":"+j+":"+k);
					
					nums[i+j+k]++;

				}
			}
		}
		for(int i=1;i<A+B+C+1;i++) {
			if(nums[i] > nums[cnt]) {
				cnt = i;
			
			}
		}
		System.out.println(cnt);
		
		
	}

}
