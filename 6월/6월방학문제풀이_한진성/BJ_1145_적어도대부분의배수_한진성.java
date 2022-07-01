import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ__1145_적어도대부분의배수 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[5];
		
		for(int i=0;i<5;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int start = arr[2];
		while(true) {
			int cnt = 0;
			for(int i=0;i<5;i++) {
				if(start%arr[i] == 0) {
					cnt++;
				}
			}
			if(cnt >= 3) {
				System.out.println(start);
				break;
			}
			start++;
		}
		

	}

}
