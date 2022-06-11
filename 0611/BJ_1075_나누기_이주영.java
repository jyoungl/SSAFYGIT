package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1075_나누기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int F = Integer.parseInt(br.readLine());
		
		c[c.length-2] = '0';
		c[c.length-1] = '0';
		
		int N = Integer.parseInt(String.valueOf(c));
	
		while(true) {
			if(N%F == 0) {
				char[] res = Integer.toString(N).toCharArray();
				System.out.printf("%c%c",res[res.length-2],res[res.length-1]);
				break;
			}
			else {
				N++;
			}
		}
	}

}
