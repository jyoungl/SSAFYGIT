package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2477_참외밭_이주영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int E=0, S=0;
		int maxw=0, maxh=0;
		int windex=0, hindex=0;
		int[][]arr = new int[6][2];
		
		for(int i=0;i<6;i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			arr[i][0] = x; arr[i][1] = y;
			
			switch(x) {
			case 1:
				E += y;
				if(maxw <= y) {
					maxw = y;
					windex = i;
				}
				break;
			case 2:
				if(maxw <= y) {
					maxw = y;
					windex = i;
				}
				break;
			case 3:
				if(maxh <= y) {
					maxh = y;
					hindex = i;
				}
				S += y;
				break;
			case 4:
				if(maxh <= y) {
					maxh = y;
					hindex = i;
				}
				break;
			default:
				break;
			}
		}
		int h1 = hindex;
		if(h1-1<0)
			h1 = 6;
		else if(h1+1>6)
			h1 -= 1;
		
		int minw = E -  Math.min(arr[h1][1], arr[hindex+1][1]);
		int minh = S - Math.min(arr[windex-1][1], arr[windex+1][1]);
		int area = (E * S) - (minw * minh);
		int res = area * K;
		System.out.println(res);
	}

}
