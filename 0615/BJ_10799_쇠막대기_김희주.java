import java.io.*;

public class BOJ_10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] input = in.readLine().toCharArray();
		int total = 0;
		int cnt = 0;
		for(int i=0;i<input.length-1;i++){
			if(input[i]==')') cnt--;
			else if(input[i+1]==')'){
				total+=cnt;
				i++;
			}
			else{
				total++;
				cnt++;
			}
		}

		System.out.println(total);
	}
}
