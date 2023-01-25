package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */
class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
};

class Node {
  public int nodeVal;
  public int importance;
}

public class EmployeeImportanceLeetcode690 {
  private static int getImportance(List<Employee> employees, int id) {
    Map<Integer, Node> employeeMap = new HashMap<>();
    Map<Integer, List<Integer>> subordinateMap = new HashMap<>();
    for(Employee employee: employees) {
      Node empNode = new Node();
      empNode.nodeVal = employee.id;
      empNode.importance = employee.importance;
      employeeMap.put(employee.id, empNode);

      subordinateMap.put(employee.id, employee.subordinates);
    }

    int totalImportance = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(id);

    Set<Integer> visited = new HashSet<>();
    visited.add(id);
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int currentId = q.poll();
        Node node = employeeMap.get(currentId);
        totalImportance += node.importance;

        List<Integer> subordinates = subordinateMap.getOrDefault(currentId, new ArrayList<>());
        if(!subordinates.isEmpty()) {
          for(Integer subordibate: subordinates) {
            if(!visited.contains(subordibate)) {
              q.add(subordibate);
              visited.add(subordibate);
            }
          }
        }
      }
    }
    return totalImportance;
  }

  public static void main(String[] args) {

  }
}
