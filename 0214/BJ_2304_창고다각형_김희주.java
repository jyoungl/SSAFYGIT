import java.io.*;
import java.util.*;

public class BOJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        StringTokenizer st;

        int[][] input = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());  //가로
            input[i][1] = Integer.parseInt(st.nextToken());  //높이
        }

        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            //현재 번호에 맞는 기둥을 list에 추가
            list.add(input[i]);

            //현재 번호 기둥의 높이
            int num = input[i][1];

            //나 다음 기둥의 최대값
            int max = Integer.MIN_VALUE;
            for(int j=i+1;j<N;j++){
                //현재 기둥보다 큰 게 있다면 i에 j값을 넣고(for문이라 -1해줌)
                if(num<input[j][1]) {
                    i = j-1;
                    break;
                }
                //없으면 나보단 작지만 그 다음으로 큰 기둥을 저장함
                if(max<input[j][1]) {
                    max = input[j][1];
                    i = j-1;
                }
            }

        }

        int area = 0;
        //맨 끝 기둥
        int[] prev = list.get(list.size()-1);
        for(int i= list.size()-2;i>=0;i--){
            //현재 기둥
            int[] cur = list.get(i);
            //만약 이전 기둥이 나보다 크다면 기둥높이만 더해줌.
            //이전 기둥은 새로 객체 넣어줌 이전기둥 가로-1, 현재기둥 높이
            if(prev[1]>cur[1]) {
                area+=prev[1];
                prev = new int[]{prev[0]-1,cur[1]};
                ++i;
                continue;
            }
            //위의 경우가 아니라면 이전-지금 넓이 더해줌
            area += Math.abs(prev[0]-cur[0])*prev[1];
            //이전꺼 바꿔줌
            prev = cur;
        }

        //맨 끝은 항상 기둥넓이가 안들어가니까 더해줌
        area += prev[1];

        System.out.println(area);
    }
}
