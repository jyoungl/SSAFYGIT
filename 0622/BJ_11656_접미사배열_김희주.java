import java.io.*;
import java.util.*;

public class BOJ_11656_접미사배열 {
	public static void main(String[] args) throws IOException {
		String S = new BufferedReader(new InputStreamReader(System.in)).readLine();
		String[] array = new String[S.length()];
		for(int i=0;i<array.length;i++){
			array[i] = S.substring(i);
		}
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]).append('\n');
		}
		System.out.print(sb);
	}
}
