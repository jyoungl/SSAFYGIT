import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1235_학생번호 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		String[] strs = new String[N];
		String[] temp = new String[N];
		for (int i = 0; i < N; i++) {

			strs[i] = in.readLine();
		}

		for (int i = strs[0].length()-1; i >= 0; i--) {
			
			for(int j=0;j<N;j++) {
				
				temp[j] = strs[j].substring(i);
				
			}
			boolean check = false;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(j == k)continue;
					
					if(temp[j].equals(temp[k])) {
						check = true;
					}
				}
			}
			
			if(!check) {
				System.out.println(strs[0].length()-i);
				return;
			}
			
		}

	}

}
