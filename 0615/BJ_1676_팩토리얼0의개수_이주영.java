package jun15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0~4 1, 5~9 2, 10~14 3, 15~24 4
public class BJ_1676_팩토리얼0의개수_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int res = 0;
		int x = Integer.parseInt(br.readLine());
		
		res = x/5 + x/25 + x/125;
		
		System.out.println(res);
	}

}
