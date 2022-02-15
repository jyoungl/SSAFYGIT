import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] > o2[1]) {
				return 1;
			}else if(o1[1] < o2[1]) {
				return -1;
			}else {
				return o1[0]-o2[0];
			}
		});
		int cnt = 1;
		int[] S = arr[0];
		int j = arr[0][1];
		for(int i=1;i<N;i++) {
			if(j < arr[i][0]) {
				S = arr[i];
				j = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);

		
	}
}
