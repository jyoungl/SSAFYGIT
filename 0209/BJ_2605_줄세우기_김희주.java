import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        List<Integer> students = new LinkedList<>();

        for(int i=1;i<=N;i++){
            students.add(i-Integer.parseInt(st.nextToken())-1,i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(students.get(i)).append(" ");
        }

        System.out.println(sb);

    }
}
