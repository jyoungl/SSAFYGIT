import java.io.*;

public class BOJ_1159_농구경기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] counts = new int[26];
		for(int i=0;i<N;i++){
			counts[in.readLine().charAt(0)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<26;i++){
			if(counts[i]>=5) sb.append((char)(i+'a'));
		}
		if(sb.length()==0) System.out.println("PREDAJA");
		else System.out.println(sb);
	}
}
