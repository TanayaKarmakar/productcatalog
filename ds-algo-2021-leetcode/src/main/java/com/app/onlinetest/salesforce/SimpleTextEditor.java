package com.app.onlinetest.salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor {
    private static StringBuilder sb;
    private static int currentCursor;

    private static StringBuilder prevSb;

    private static final int APPEND = 1;
    private static final int DELETE = 2;
    private static final int PRINT = 3;
    private static final int UNDO = 4;

    public static List<String> performOperations(List<String> commands) {
        commands = commands.subList(1, commands.size());
        sb = new StringBuilder();
        prevSb = new StringBuilder();
        currentCursor = 0;
        List<String> output = new ArrayList<>();
        for(String currentCommand: commands) {
            String[] tokens = currentCommand.split("\\s+");
            Integer command = Integer.parseInt(tokens[0]);
            String args = command == 4 ? "": tokens[1];
            switch(command) {
                case APPEND:
                    prevSb = new StringBuilder(sb);
                    sb.append(args);
                    currentCursor = sb.length();
                    continue;
                case DELETE:
                    prevSb = new StringBuilder(sb);
                    deleteChars(args);
                    continue;
                case PRINT:
                    printChar(args, output);
                    continue;
                case UNDO:
                    sb = new StringBuilder(prevSb);
            }
        }
        return output;
    }

    private static void printChar(String args, List<String> output) {
        System.out.println(sb.toString() + ":" + args);
        Integer k = Integer.parseInt(args);
        output.add(sb.charAt(k-1) + "");
    }

    private static void deleteChars(String args) {
        Integer kChars = Integer.parseInt(args);
        String s = sb.substring(0, sb.length() - kChars);
        sb = new StringBuilder(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> commands = new ArrayList<>();
        Integer nQueries = scanner.nextInt();
        int i = 0;
        while(i <= nQueries) {
            String command = scanner.nextLine();
            commands.add(command);
            i++;
        }

        List<String> output = performOperations(commands);
        System.out.println(output);
    }
}
