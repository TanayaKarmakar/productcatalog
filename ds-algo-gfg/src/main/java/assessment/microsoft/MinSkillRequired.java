package assessment.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 19/05/22
 * @project ds-algo-2021
 */
public class MinSkillRequired {
    private static int solution(int[] T, int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> revMap = new HashMap<>();

        int count = 0;
        for(int i = 0; i < A.length; i++) {
            int k = T[A[i]];
            while(k != 0) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
                if(!revMap.containsKey(k))
                    revMap.put(k, new ArrayList<>());
                revMap.get(k).add(A[i]);
                k = T[k];
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if(!revMap.containsKey(k))
                revMap.put(k, new ArrayList<>());
            revMap.get(k).add(A[i]);
        }

        int part1 = 0;
        for(Map.Entry<Integer, List<Integer>> entry: revMap.entrySet()) {
            if(entry.getValue().size() == A.length) {
                part1 = entry.getValue().size();
                break;
            }
        }

        int part2 = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            part2 = Integer.max(part2, entry.getValue());
        }

        return part1 + part2;
    }

    public static void main(String[] args) {
        int[] T = {0,0,0,0,2,3,3};
        int[] A = {2,5,6};

        int ans = solution(T, A);

        System.out.println(ans);

        T = new int[] {0,3,0,0,5,0,5};
        A = new int[] {4,2,6,1,0};

        ans = solution(T, A);

        System.out.println(ans);
    }
}
