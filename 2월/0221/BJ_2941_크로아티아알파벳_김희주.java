import java.io.*;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();

		int count = 0;
		for (int i = line.length() - 1; i >= 0; i--) {
			count++;
			if(line.charAt(i)=='=') {
				i--;
				if(i-1>=0 && line.charAt(i)=='z' && line.charAt(i-1)=='d') i--;
			}else if(line.charAt(i)=='-') {
				i--;
			}else if(line.charAt(i)=='j') {
				if(i-1>=0 && (line.charAt(i-1)=='n' || line.charAt(i-1)=='l')) i--;
			}
		}
		
		System.out.println(count);
		
		//두 번째 방법
		String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};

		for(int i=0;i<8;i++){
			line = line.replaceAll(str[i],".");
		}

		System.out.println(line.length());
		

	}
}
