import java.io.*;
import java.util.*;

public class BOJ_1251_단어나누기 {
	public static void main(String[] args) throws IOException {
		char[] word = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		ArrayList<String> list = new ArrayList<>();
		StringBuilder tmp;
		for(int i=0;i<word.length-2;i++){
			for(int j=i+1;j<word.length-1;j++){
				tmp = new StringBuilder();
				for(int w=i;w>=0;w--){
					tmp.append(word[w]);
				}
				for(int w=j;w>i;w--){
					tmp.append(word[w]);
				}
				for(int w=word.length-1;w>j;w--){
					tmp.append(word[w]);
				}
				list.add(tmp.toString());
			}
		}
		Collections.sort(list);

		System.out.println(list.get(0));

	}
}
