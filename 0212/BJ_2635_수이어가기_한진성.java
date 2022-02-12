import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2635_수이어가기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int max = 0;
		List<Integer> anslist = null;
		for(int i=0;i<=N;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			while(true) {
				list.add(list.get(list.size()-2) - list.get(list.size()-1));
				
				if(list.get(list.size()-1) < 0) {
					list.remove(list.size()-1);
					break;
				}
			}
			if(max < list.size()) {
				max = list.size();
				anslist = list;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(anslist.size()).append("\n");
		for(int i=0;i<anslist.size();i++) {
			sb.append(anslist.get(i)).append(" ");
		}
		System.out.println(sb);
		
	}
}
