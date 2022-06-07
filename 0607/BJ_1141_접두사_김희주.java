import java.io.*;
import java.util.*;

public class BOJ_1141_접두사 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<String> list = new ArrayList<>(N);
		for(int i=0;i<N;i++) list.add(in.readLine());

		Collections.sort(list);

		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size();j++){
				if(list.get(j).startsWith(list.get(i))) {
					list.remove(i);
					i--;
					break;
				}
			}
		}

		System.out.println(list.size());
	}
}
