import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] students = new int[2][6];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(in.readLine());
            students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
        }

        int room = 0;
        for(int i=0;i<6;i++){
            for(int j=0;j<2;j++){
                room += Math.ceil(students[j][i]/(double)K);
            }
        }

        System.out.println(room);
    }
}
