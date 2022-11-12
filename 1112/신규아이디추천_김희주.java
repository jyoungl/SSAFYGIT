import java.util.*;

class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        
        //3단계
        new_id = new_id.replaceAll("[.]+",".");
        
        //4단계
        new_id = new_id.replaceAll("^[.]|[.]$","");
        //if(new_id.startsWith(".")) new_id = new_id.substring(1);
        //if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
        
        //5단계
        if(new_id.length()==0) new_id = "a";
        
        //6단계
        if(new_id.length()>=16) new_id = new_id.substring(0,15);
        new_id = new_id.replaceAll("[.]$","");
        //if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
        
        //7단계
        StringBuilder sb = new StringBuilder();
        sb.append(new_id);
        while(sb.length()<=2){
            sb.append(new_id.charAt(new_id.length()-1));
        }
        
        return sb.toString();
    }
}
