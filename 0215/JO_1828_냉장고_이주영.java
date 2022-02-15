import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828_냉장고_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //최저
			arr[i][1] = Integer.parseInt(st.nextToken()); //최고
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}		
		});
		
		int cnt = 1;
		int max = arr[0][1];
		
		for(int i=1;i<N;i++) {
			if(max < arr[i][0]) {
				max = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
