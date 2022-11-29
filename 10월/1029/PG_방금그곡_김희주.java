import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public String solution(String m, String[] musicinfos) throws Exception {
        //m : 네오가 기억한 멜로디 담은 문자열
        //musicinfos : 방송된 곡의 정보 담은 배열. 시작시각,끝난시각,음악제목,악보정보 HH:MM
        //음은 1분에 1개씩. 
        //음악은 반드시 처음부터 재생. 음악길이 > 재생시간 = 처음부터 반복재생
        //조건일치 여러개 : 재생된시간 -> 먼저 입력된 음악
        //조건 불일치 : (None) 반환
        
        // m에서 #붙은 음을 소문자로 변경
        StringBuilder msb = new StringBuilder();
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)=='#') msb.setCharAt(msb.length()-1,(char)(m.charAt(i-1)-'A'+'a'));
            else msb.append(m.charAt(i));
        }
        m = msb.toString();
        
        //musicinfos 탐색 및 변경
        StringTokenizer st;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long ans_dif = 0;
        String ans_title = "(None)";
        for(int i=0;i<musicinfos.length;i++){
            st = new StringTokenizer(musicinfos[i],",");
            
            //악보 재생시간 구하기.
            long dif = -sdf.parse(st.nextToken()).getTime() + sdf.parse(st.nextToken()).getTime();
            dif /= (1000*60);
            //재생시간이 미리 저장된 ans_dif보다 길지않거나, m보다 짧으면 계산x
            if(ans_dif >= dif || dif < m.length()) continue;
            
            String title = st.nextToken();
            String note = st.nextToken();
            StringBuilder notes = new StringBuilder();
            
            //#붙은 음을 소문자로 변경
            for(int j=0;j<note.length();j++){
                if(note.charAt(j)=='#') notes.setCharAt(notes.length()-1,(char)(note.charAt(j-1)-'A'+'a'));
                else notes.append(note.charAt(j));
            }
            note = notes.toString();
            
            //note늘리기
            for(int j=0;j<=(dif / note.length());j++){
                notes.append(note);
            }
            
            //substring한 결과에 m이 포함되어있다면 결과교체
            if(notes.substring(0,(int)dif+1).contains(m)){
                ans_dif = dif;
                ans_title = title;
            }
            
        }
        
        return ans_title;
    }
}
