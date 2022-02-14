import java.util.ArrayList;
import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이_이주영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			arr.add(in.nextInt());
			sum += arr.get(i);
		}
		
		int x = sum - 100;
		cal:
		for(int i=0;i<8;i++) { //맨 뒤까지 포함하면 두번째 for문에서 index에러가 나니까
			for(int j=i+1;j<9;j++) {
				int y =0;
				y += arr.get(i);
				y += arr.get(j);
				if(y == x) {
					int a = arr.get(i);
					int b = arr.get(j);
					arr.remove(Integer.valueOf(a));
					arr.remove(Integer.valueOf(b));
					break cal;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		arr.sort(null);
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i)+"\n");
		}
		System.out.println(sb);
	}

}
