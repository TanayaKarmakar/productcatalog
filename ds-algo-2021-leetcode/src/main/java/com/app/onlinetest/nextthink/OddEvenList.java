package com.app.onlinetest.nextthink;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class OddEvenList {
  static class Node {
    int data;
    Node next;
    Node() {}
    Node(int data) { this.data = data; }
    Node(int data, Node next) { this.data = data; this.next = next; }
  }


  private static Node solve(Node head) {
    if(head == null || head.next == null)
      return head;

    Node oddList = new Node(Integer.MAX_VALUE);
    Node evenList = new Node(Integer.MAX_VALUE);
    Node oddPtr = oddList;
    Node evenPtr = evenList;
    Node current = null;

    int indx = 1;
    Node ptr = head;
    while(ptr != null) {
      current = ptr;
      ptr = ptr.next;
      current.next = null;
      if(indx % 2 != 0) {
        oddPtr.next = current;
        oddPtr = oddPtr.next;
      } else {
        evenPtr.next = current;
        evenPtr = evenPtr.next;
      }
      indx++;
    }

    oddList = oddList.next;
    evenList = evenList.next;
    oddPtr.next = evenList;

    return oddList;
  }

  public static Node createList(int[] arr){
    if (arr.length == 0) {
      return null;
    }
    Node head = new Node(arr[0]);
    Node temp = head;
    for(int i = 1 ; i < arr.length ; i++){
      temp.next=new Node(arr[i]);
      temp = temp.next;
    }
    return head;
  }

  public static void print(Node head){
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data + " -> ");
      temp=temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2};

    Node head = createList(arr);
    print(head);
    print(solve(head));
  }
}
