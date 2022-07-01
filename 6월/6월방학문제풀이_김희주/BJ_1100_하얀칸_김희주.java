import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100_하얀칸 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		boolean isWhite;
		int count = 0;
		for(int i=0;i<8;i++){
			line = in.readLine();
			isWhite = i%2==0;
			for(int j=0;j<8;j++){
				if(isWhite && line.charAt(j)=='F') count++;
				isWhite = !isWhite;
			}
		}

		System.out.println(count);
	}
}
