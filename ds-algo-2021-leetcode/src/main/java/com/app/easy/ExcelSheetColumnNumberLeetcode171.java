package com.app.easy;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class ExcelSheetColumnNumberLeetcode171 {
    private static int titleToNumber(String columnTitle) {
        int total = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            total = total * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
