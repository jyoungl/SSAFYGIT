package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_10825_국영수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] student = new String[N][4];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				student[i][j] = st.nextToken();
			}
		}
		
		Arrays.sort(student, new Comparator<String[]>(){		
            @Override
            public int compare(String[] o1, String[] o2){
                if(o2[1].equals(o1[1])){
                    if(o1[2].equals(o2[2])){
                        if(o1[3].equals(o2[3])){
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
                    }

                    return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);

                }
                return Integer.parseInt(o2[1])- Integer.parseInt(o1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
			sb.append(student[i][0] + "\n");
		}
        
        System.out.println(sb);

	}

}
