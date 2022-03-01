package easy;

/**
 * @author t0k02w6 on 08/02/22
 * @project ds-algo-2021
 */
public class LongestCommonPrefixLeetcode14 {
    private static String longestCommonPrefix(String[] strs) {
        String str = strs[0];

        for(int i = 1; i < strs.length; i++) {
            String currentStr = strs[i];
            int i1 = 0;
            int j1 = 0;
            int count = 0;
            while(i1 < str.length() && j1 < currentStr.length()
                    && str.charAt(i1) == currentStr.charAt(j1)) {
                i1++;
                j1++;
                count++;
            }
            str = str.substring(0, count);
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
