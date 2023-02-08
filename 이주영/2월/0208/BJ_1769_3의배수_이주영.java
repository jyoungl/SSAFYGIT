package feb08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1769_3의배수_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		long x = 0;
		int cnt = 0;
		while(true) {
			if(str.length() == 1)
				break;
			x = 0;
			for(int i=0;i<str.length();i++)
				x += (str.charAt(i)-'0');
			cnt++;
			str = String.valueOf(x);
		}
		
		System.out.println(cnt);
		if(Integer.parseInt(str)%3==0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
