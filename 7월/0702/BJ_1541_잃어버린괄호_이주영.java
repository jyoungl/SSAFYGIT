package jul02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541_잃어버린괄호_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int res = Integer.MAX_VALUE;
		
		for(int i=0;i<str.length;i++) {
			int x = 0;
			
			String[] str2 = str[i].split("\\+");
			for(int j=0;j<str2.length;j++)
				//System.out.println(str[j]);
				x += Integer.parseInt(str2[j]);
			
			if(res == Integer.MAX_VALUE)
				res = x;
			else
				res -= x;
		}
		
		System.out.println(res);
		
	}

}
