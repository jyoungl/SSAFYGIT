package mar24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];

        for (int i=0; i<n; i++) {
            house[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(house);

        int start = 1;
        int end = house[n-1] - house[0];

        int result = 0;

        //1 2 4 8 9

        while (start <= end) {
            int mid = (start+end)/2;//정답후보
            int left = house[0];
            int cnt = 1;//공유기 갯수(맨 왼쪽집에 하나 설치하고 시작해서 1)

            for (int i=1; i<n; i++) {
                if (house[i]-left>=mid) {
                    //house[i]-left = 간격
                    //최소거리
                    cnt++;
                    left = house[i];
                }
            }

            if (cnt>=c) {
                //실제 설치될 공유기보다 많이 설치함 -> 오른쪽으로 이동해 더 긴 간격 찾아야함
                result = mid;
                start = mid+1;
            } else {
                //공유기를 c보다 적게 설치함 -> 왼쪽으로 이동해 더 짧은 간격 찾아야함
                end = mid-1;
            }
        }

        System.out.println(result);
		
	}

}
