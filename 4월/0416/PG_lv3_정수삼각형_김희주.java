import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for(int j=triangle.length-1;j>0;j--){
            int idx = 0;
            for(int i=0;i<triangle[j].length-1;i++){
                triangle[j-1][idx++] += Math.max(triangle[j][i], triangle[j][i+1]);
            }
        }

        return triangle[0][0];
    }
}
