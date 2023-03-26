import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        Arrays.fill(answer, 1);
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        outer: for(int n = 0; n<5; n++) {
            for(int i = 0; i<5; i++) {
                for(int j = 0; j<5; j++){
                    if(places[n][i].charAt(j) == 'O') {
                        int sum = 0;
                        outer1: for(int k = 0; k<4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if(x < 0 || x >= 5 || y < 0 || y >= 5) continue outer1;
                            if(places[n][x].charAt(y) == 'P') sum++;
                            if(sum >= 2) {
                                answer[n] = 0;
                                continue outer;
                            }
                        }
                    } else if(places[n][i].charAt(j) == 'P') {
                        outer2: for(int k = 0; k<4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if(x < 0 || x >= 5 || y < 0 || y >= 5) continue outer2;
                            if(places[n][x].charAt(y) == 'P') {
                                answer[n] = 0;
                                continue outer;
                            }
                        }
                    }
                }
                
            }
        }
        
        return answer;
    }
}
