import java.io.*;
import java.util.*;

public class BOJ_1431_시리얼번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] input = new String[N];
		for(int i=0;i<N;i++) input[i] = in.readLine();

		Arrays.sort(input,(o1,o2)->{
			if(o1.length() != o2.length()) return o1.length()-o2.length();
			int a=0,b=0;
			for(int i=0;i<o1.length();i++){
				if(o1.charAt(i)>='0' && o1.charAt(i)<='9') a+=o1.charAt(i)-'0';
			}
			for(int i=0;i<o2.length();i++){
				if(o2.charAt(i)>='0' && o2.charAt(i)<='9') b+=o2.charAt(i)-'0';
			}
			if(a != b) return a-b;
			return o1.compareTo(o2);
		});

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) sb.append(input[i]).append('\n');
		System.out.print(sb);
	}
}
