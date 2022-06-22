import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		
		List<String> list = new ArrayList<>();

		for(int i=0,n=str.length();i<n;i++) {
			list.add(str.substring(i));
		}
		
		Collections.sort(list);
		
		for(String ans : list) {
			System.out.println(ans);
		}
		
	}

}
