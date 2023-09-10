package com.app.product.productcatalog.util;


public class StringUtil {
    public static String buildFinalString(String delimiter, String ...args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length - 1; i++) {
            sb.append(args[i]);
            sb.append(delimiter);
        }
        sb.append(args[args.length - 1]);
        return sb.toString();
    }

    public static String buildFinalStringWithoutDelims(String ...args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]);
        }
        return sb.toString();
    }
}
