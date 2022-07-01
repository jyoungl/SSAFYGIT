import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032_명령프롬프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[][] input = new char[N][];
		for(int i=0;i<N;i++) input[i] = in.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		char ch;
		boolean flag;
		for(int i=0;i<input[0].length;i++){
			ch = input[0][i];
			flag= true;
			for(int j=1;j<N;j++){
				if(ch!=input[j][i]) {
					flag = false;
					break;
				}
			}
			if(flag) sb.append(ch);
			else sb.append('?');

		}

		System.out.print(sb);
	}
}
