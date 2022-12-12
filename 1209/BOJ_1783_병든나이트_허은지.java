import java.io.*;
import java.util.*;

/*
세로 N x 가로 M 크기 체스판
N과 M은 long으로 받아야 함
2칸 위로, 1칸 오른쪽
1칸 위로, 2칸 오른쪽
1칸 아래로, 2칸 오른쪽
2칸 아래로, 1칸 오른쪽
이동 횟수가 4번 이상(방문한 칸이 5칸 이상)이면 이동 방법을 한 번씩 다 사용해야함 -> 다 쓸 수 있는 방법이 없다면 4칸으로 한정
N>=3 & M>=7일 때 무조건 전부다 사용, -3 -7한 다음 거기에서 다시 시작
오른쪽으로만 가기때문에 오른쪽 끝까지 가기 전에 최대로 해야 됨 -> M에 맞추기
 */
public class S3_1783_병든나이트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long ans = 0;
        
        if(N==1) ans = 1;
        else if (N==2) ans = Math.min((M+1)/2, 4);
        else if(M<7) ans = Math.min(M, 4);
        else ans = M - 2;

        System.out.println(ans);
    }

}
