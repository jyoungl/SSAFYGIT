import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_단어공부 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[200];
		
		String str = in.readLine();
		
		
		for(int i=0,n=str.length();i<n;i++) {
			int temp = str.charAt(i);
			
			if(temp > 96) {
				temp = temp - 32;
			}
			arr[temp]++;
		}
		int max = 0;
		char ans = '.';
		for(int i=0;i<200;i++) {
			
			if(max < arr[i]) {
				max = arr[i];
				ans = (char) i;
			}else if(max != 0 && max == arr[i]) {
				ans = '?';
			}
		}
		
		System.out.println(ans);
	}

}
