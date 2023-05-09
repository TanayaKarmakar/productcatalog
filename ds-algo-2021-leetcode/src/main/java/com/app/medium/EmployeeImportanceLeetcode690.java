package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 08/05/23
 * @project ds-algo-2021-leetcode
 */
public class EmployeeImportanceLeetcode690 {
  static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  }

  private static int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    for(Employee employee: employees) {
      employeeMap.put(employee.id, employee);
    }

    int totalImportance = 0;
    Queue<Integer> q = new LinkedList<>();

    q.add(id);

    while(!q.isEmpty()) {
      int size = q.size();
      int importanceAtCurrentLevel = 0;
      for(int i = 0; i < size; i++) {
        int currentId = q.poll();
        Employee employee = employeeMap.get(currentId);
        importanceAtCurrentLevel += employee.importance;
        List<Integer> subordinates = employee.subordinates;
        if(!subordinates.isEmpty()) {
          q.addAll(subordinates);
        }
      }
      totalImportance += importanceAtCurrentLevel;
    }

    return totalImportance;
  }



  public static void main(String[] args) {

  }
}
