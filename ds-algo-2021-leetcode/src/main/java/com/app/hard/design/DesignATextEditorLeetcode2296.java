package com.app.hard.design;

import java.util.Iterator;
import java.util.Stack;

public class DesignATextEditorLeetcode2296 {
    static class TextEditor {
//        static class DoublyLinkedList {
//            char ch;
//            DoublyLinkedList prev;
//            DoublyLinkedList next;
//
//            public DoublyLinkedList(char ch) {
//                this.ch = ch;
//            }
//        }
//
//        DoublyLinkedList head;
//        DoublyLinkedList current;
        int cursorIndx = 0;
        Stack<Character> stack;

        public TextEditor() {
            stack = new Stack<>();
        }

        public void addText(String text) {
            Stack<Character> temp = new Stack<>();
            while(!stack.isEmpty() && stack.peek() != '|') {
                temp.push(stack.pop());
            }
            if(!stack.isEmpty()) {
                stack.pop();
            }
            for(int i = 0; i < text.length(); i++) {
                stack.push(text.charAt(i));
            }
            stack.push('|');
            cursorIndx = stack.size();
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        public int deleteText(int k) {
            if(stack.isEmpty())
                return 0;
            stack.pop();
            while(!stack.isEmpty() && k-- > 0) {
                stack.pop();
            }
            stack.push('|');
            cursorIndx = stack.size();
            return stack.size();
        }

        public String cursorLeft(int k) {
            if(stack.isEmpty())
                return "";
            Stack<Character> tempStack = new Stack<>();
            stack.pop();
            while(!stack.isEmpty() && k-- > 0) {
                tempStack.push(stack.pop());
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Character> sItr = stack.iterator();
            while(!sItr.hasNext()) {
                sb.append(sItr.next());
            }
            stack.push('|');
            cursorIndx = stack.size();
            while(!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return sb.toString();
        }

        public String cursorRight(int k) {
            if(stack.isEmpty())
                return "";
            Stack<Character> temp = new Stack<>();
            while(!stack.isEmpty() && stack.peek() != '|') {
                temp.push(stack.pop());
            }
            stack.pop();
            while(!temp.isEmpty() && k-- > 0) {
                stack.push(temp.pop());
            }
            Iterator<Character> sItr = stack.iterator();
            StringBuilder sb = new StringBuilder();
            while(sItr.hasNext()) {
                sb.append(sItr.next());
            }

            stack.push('|');
            cursorIndx = stack.size();
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {

    }
}
