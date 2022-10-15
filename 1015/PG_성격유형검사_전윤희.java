import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int value;
    public String solution(String[] survey, int[] choices) {
        // 성격유형검사중 앞글자 점수는 (-)붙이기
        int[] newChoices = new int[choices.length];
        for (int i = 0; i < newChoices.length; i++) {
            newChoices[i] = choices[i] - 4;
        }

        // 각 유형별 가중치값 계산하기
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("R", 0);
        hm.put("T", 0);

        hm.put("C", 0);
        hm.put("F", 0);

        hm.put("J", 0);
        hm.put("M", 0);

        hm.put("A", 0);
        hm.put("N", 0);

        value = 0;
        for (int i = 0; i < survey.length; i++) {
            String[] type = new String[2];
            type = survey[i].split("");
            value = newChoices[i];

            // value가 음수이면 지표순서상 앞유형에 가산
            if (value < 0) {
                value = hm.get(type[0]) + Math.abs(value);
                hm.put(type[0], value);
            } else { // value가 양수이면 지표순서상 뒷유형에 가산
                value = hm.get(type[1]) + Math.abs(value);
                hm.put(type[1], value);
            }
        }

        if (hm.get("R") < hm.get("T")) {
            sb.append("T");
        } else {
            sb.append("R");
        }

        if (hm.get("C") < hm.get("F")) {
            sb.append("F");
        } else {
            sb.append("C");
        }

        if (hm.get("J") < hm.get("M")) {
            sb.append("M");
        } else {
            sb.append("J");
        }

        if (hm.get("A") < hm.get("N")) {
            sb.append("N");
        } else {
            sb.append("A");
        }

        return sb.toString();
    }
}
