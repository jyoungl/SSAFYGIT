import java.io.*;

public class BOJ_1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		char[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int[] count = new int[2];

		char prev = input[0];
		count[prev-'0']++;
		for(int i=1;i<input.length;i++){
			if(prev != input[i]){
				prev = input[i];
				count[input[i]-'0']++;
			}
		}
		System.out.println(Math.min(count[0], count[1]));
	}
}
