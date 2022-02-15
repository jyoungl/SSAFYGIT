import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int cloud;
        for(int h=0;h<H;h++){
            String sky = in.readLine();
            cloud = -1;
            for(int w=0;w<W;w++){
                if(sky.charAt(w)=='c') {
                    sb.append("0 ");
                    cloud = w;
                }
                else if(cloud == -1) sb.append(-1).append(" ");
                else sb.append(w-cloud).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString().trim());

    }
}
