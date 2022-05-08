package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class MeetingMaximumGuests {
    private static int maxCount(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n = arrival.length;
        int count = 0;
        int i = 0;
        int j = 0;

        int maxCount = 0;
        while(i < n && j < n) {
            if(arrival[i] < departure[j]) {
                count++;
                i++;
                maxCount = Integer.max(count, maxCount);
            } else {
                count--;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arrival = {800, 700, 600, 500};
        int[] departure = {840, 820, 830, 530};

        int ans = maxCount(arrival, departure);

        System.out.println(ans);
    }
}
