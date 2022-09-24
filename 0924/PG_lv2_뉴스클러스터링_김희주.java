import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        double answer = 0;
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        //str1리스트 채우기
        for(int i=0;i<str1.length()-1;i++){
            String tmp = str1.substring(i,i+2);
            if(!tmp.matches("^[A-Z]*$")) continue;
            // if(tmp.charAt(0)<'A' || tmp.charAt(1)<'A' || tmp.charAt(0)>'Z' || tmp.charAt(1)>'Z') continue;
            str1List.add(tmp);
        }        
        
        Collections.sort(str1List);
        
        //교집합 개수 구하면서 str2 리스트 채우기
        //동일한 원소가 있다면 str1리스트에서 지우고 str2리스트에도 추가하지 않음
        double share = 0;
        for(int i=0;i<str2.length()-1;i++){
            String tmp = str2.substring(i,i+2);
            if(!tmp.matches("^[A-Z]*$")) continue;
            // if(tmp.charAt(0)<'A' || tmp.charAt(1)<'A' || tmp.charAt(0)>'Z' || tmp.charAt(1)>'Z') continue;
            int idx = Collections.binarySearch(str1List,tmp);
            if(idx >= 0){
                str1List.remove(idx);
                share++;
            }else {
                str2List.add(tmp);
            }
        }
        
        //교집합 개수 0이면서 두 리스트 사이즈가 전부 0이라면 1. 1*65536=65536
        if(share==0 && str1List.size()==0 && str2List.size()==0) return 65536;
        
        //답구하기
        answer = share / (str1List.size()+str2List.size()+share);
        return (int)(answer*65536);
    }
}
