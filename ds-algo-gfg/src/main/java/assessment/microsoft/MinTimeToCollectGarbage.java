package assessment.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 19/05/22
 * @project ds-algo-2021
 */
public class MinTimeToCollectGarbage {
    private static int solution(int[] D, String[] T) {
        // write your code in Java SE 8
        int n = D.length;
        int prefix = 0;
        int[] totalTime = new int[n];
        for(int i = 0; i < n; i++) {
            int time = 0;
            prefix += D[i];
            String str = T[i];
            if(!str.isEmpty()) {

                Set<Character> set = new HashSet<>();
                for(int j = 0; j < str.length(); j++) {
                    set.add(str.charAt(j));
                }
                time = set.size() * prefix;
                time += set.size();
                time += prefix;
            }
            totalTime[i] = time;

        }
        return totalTime[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,5}, new String[]{"PGP","M"}));
        System.out.println(solution(new int[]{2,1,1,1,2}, new String[]{"", "PP", "PP", "GM", ""}));
    }
}
