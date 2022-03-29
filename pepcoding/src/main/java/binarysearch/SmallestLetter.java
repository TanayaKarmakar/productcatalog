package binarysearch;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
public class SmallestLetter {
    private static char nextGreaterCharacter(char[] chars, char target) {
        int n = chars.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(target < chars[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return chars[start % chars.length];
    }

    public static void main(String[] args) {
        char[] chars = {'c', 'd','f','j'};
        char target = 'j';

        char ans = nextGreaterCharacter(chars, target);

        System.out.println(ans);
    }
}
