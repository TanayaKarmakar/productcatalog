package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 10/05/22
 * @project ds-algo-2021
 */
public class NaivePatternMatchingWithDistinctCharacters {
    private static List<Integer> searchPatterns(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        for(i = 0; i <= (n - m);) {
            for(j = 0; j < m; j++) {
                if(pattern.charAt(j) != txt.charAt(i + j))
                    break;
            }

            if(j == m)
                result.add(i);
            if(j == 0)
                i++;
            else
                i = i + j;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        String pattern = scanner.nextLine();

        System.out.println(searchPatterns(txt, pattern));

        scanner.close();
    }
}
