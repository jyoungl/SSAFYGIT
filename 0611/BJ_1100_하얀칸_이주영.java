package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1100_하얀칸_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		
		for(int i=0;i<8;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				char[] c = str.toCharArray();
				
				if(i%2==0) {
					if(j%2==0 && c[j] == 'F')
						res++;
				}
				else {
					if(j%2==1 && c[j] == 'F')
						res++;
				}
			}
		}
		
		System.out.println(res);
		
	}

}
