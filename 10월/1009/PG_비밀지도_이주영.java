import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        for(int i=0;i<n;i++){
            map[i] = "";
            int x = arr1[i];
            String str = Integer.toBinaryString(x);
            x = arr2[i];
            String str2 = Integer.toBinaryString(x);
            int a = str.length();
            int b = str2.length();

            if(a < n){
                for(int j=0;j<n-a;j++){
                    str = "0" + str;
                }
            }
            if(b < n){
                for(int j=0;j<n-b;j++){
                    str2 = "0" + str2;
                }
            }

            char[] ch = str.toCharArray();
            char[] ch2 = str2.toCharArray();
            for(int j=0;j<n;j++){
                if(ch[j] == '1' || ch2[j] == '1'){
                    map[i] += "#";
                }
                else{
                    map[i] += " ";
                }
            }
        }
        return map;
    }
}
