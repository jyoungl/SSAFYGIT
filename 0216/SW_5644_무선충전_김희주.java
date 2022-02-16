import java.io.*;
import java.util.*;

public class SW_5644_무선충전 {
    static BC[] bc;
    static StringBuilder sb = new StringBuilder();
    static int[][] deltas = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};//x,y순, 이동없음 상 우 하 좌
    static Location[][] people;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(st.nextToken());//이동시간
            int A = Integer.parseInt(st.nextToken());//BC 개수

            people = new Location[M + 1][2];

            //사용자 위치
            people[0][0] = new Location(1, 1);
            people[0][1] = new Location(10, 10);
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(in.readLine());
                for (int m = 1; m <= M; m++) {
                    int d = Integer.parseInt(st.nextToken());
                    people[m][i] = new Location(people[m - 1][i].x + deltas[d][0], people[m - 1][i].y + deltas[d][1]);
                }
            }

            //배터리 충전기
            bc = new BC[A];
            for (int a = 0; a < A; a++) {
                st = new StringTokenizer(in.readLine());
                bc[a] = new BC(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
            }

            //M+1만큼 탐색
            int sum = 0;
            List<Integer> tmpD1 = new ArrayList<>(), tmpD2 = new ArrayList<>();
            for (int m = 0; m <= M; m++) {
                //가능한 배터리 모두 list에 추가
                for (int a = 0; a < A; a++) {
                    if (bc[a].isAvailable(people[m][0])) tmpD1.add(a);
                    if (bc[a].isAvailable(people[m][1])) tmpD2.add(a);
                }

                Collections.sort(tmpD1, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return bc[o2].performance-bc[o1].performance;
                    }
                });
                Collections.sort(tmpD2, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return bc[o2].performance-bc[o1].performance;
                    }
                });

                //가능한 배터리 중 어떤 선택이 나은지 체크
                int tmpMax = 0;
                // 둘 다 가능한 게 없으면 넘어감
                if (tmpD1.size() == 0 && tmpD2.size() == 0) continue;


                // 둘 다 하나 이상
                if (tmpD1.size() >= 1 && tmpD2.size() >= 1) {

                    for(int i=0;i<Math.min(2,tmpD1.size());i++){

                        for(int j=0;j<Math.min(2,tmpD2.size());j++){

                            if(tmpD1.get(i).equals(tmpD2.get(j))) tmpMax = Math.max(tmpMax, bc[tmpD1.get(i)].performance);
                            else tmpMax = Math.max(tmpMax, bc[tmpD1.get(i)].performance + bc[tmpD2.get(j)].performance);

                        }
                    }

//
//                    for (int i : tmpD1) {
//                        for (int j : tmpD2) {
//                            if (i == j) tmpMax = Math.max(tmpMax, bc[i].performance);
//                            else tmpMax = Math.max(tmpMax, bc[i].performance + bc[j].performance);
//                        }
//                    }
                }
                //둘 중 하나가 0개
                else if (tmpD1.size() == 0) {
                    tmpMax = bc[tmpD2.get(0)].performance;
//                    for (int i : tmpD2) {
//                        tmpMax = Math.max(tmpMax, bc[i].performance);
//                    }

                } else {// else if(tmpD2.size()==0){
                    tmpMax = bc[tmpD1.get(0)].performance;
//                    for (int i : tmpD1) {
//                        tmpMax = Math.max(tmpMax, bc[i].performance);
//                    }
                }

                //합계추가
                sum += tmpMax;

                //다음 반복을 위해 list clear
                tmpD1.clear();
                tmpD2.clear();
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);

    }
}

class BC {
    Location location;
    int coverage;
    int performance;

    BC(String x, String y, String coverage, String performance) {
        this.location = new Location(Integer.parseInt(x), Integer.parseInt(y));
        this.coverage = Integer.parseInt(coverage);
        this.performance = Integer.parseInt(performance);
    }

    boolean isAvailable(Location o) {
        return coverage >= location.calcDistance(o);
    }
}

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int calcDistance(Location o) {
        return Math.abs(x - o.x) + Math.abs(y - o.y);
    }
}
