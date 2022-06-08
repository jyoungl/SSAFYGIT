import java.io.*;

public class BOJ_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		String word = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();
		int[] counts = new int[26];
		for(int i=0;i<word.length();i++){
			counts[word.charAt(i)-'A']++;
		}

		int cnt = 1;
		int max = 0;
		for(int i=1;i<26;i++){
			if(counts[max]<counts[i]){
				max = i;
				cnt = 1;
			}else if(counts[max]==counts[i]){
				cnt++;
			}
		}

		if(cnt>1) System.out.println("?");
		else System.out.println((char)(max+'A'));
	}
}
