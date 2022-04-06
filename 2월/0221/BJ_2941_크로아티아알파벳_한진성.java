import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars = in.readLine().toCharArray();
		
		int cnt = 0;
		
		for(int i=0, len = chars.length;i<len;i++) {
			
			switch(chars[i]) {
			case 'c':
				if(i+1 < len && chars[i+1] == '=') {
					i++;
				}else if(i+1 < len && chars[i+1] == '-') {
					i++;
				}
				break;
			case 'd':
				if(i+1 <len &&  chars[i+1] == '-') {
					i++;
				}else if(i+2 < len && chars[i+1] == 'z' && chars[i+2] == '=') {
					i+=2;
				}
				break;
			case 'l':
				if(i+1 < len && chars[i+1] == 'j') {
					i++;
				}
				break;
			case 'n':
				if(i+1 < len && chars[i+1] == 'j') {
					i++;
				}
				break;
			case 's':
				if(i+1 < len && chars[i+1] == '=') {
					i++;
				}
				break;
			case 'z':
				if(i+1 < len && chars[i+1] == '=') {
					i++;
				}
				break;
			}
			cnt++;
			
		}
		
		System.out.println(cnt);
		
	}

}
