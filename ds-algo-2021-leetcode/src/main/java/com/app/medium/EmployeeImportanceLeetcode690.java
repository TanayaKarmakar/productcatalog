package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class EmployeeImportanceLeetcode690 {
  static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  };

  private static int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    for(Employee employee: employees) {
      employeeMap.put(employee.id, employee);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(id);

    int totalImportance = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      int currentImportance = 0;
      for(int i = 0; i < size; i++) {
        int empId = queue.poll();
        Employee employee = employeeMap.get(empId);
        currentImportance += employee.importance;

        List<Integer> subordinates = employee.subordinates;
        if(!subordinates.isEmpty()) {
          for(Integer subordinate: subordinates) {
            queue.add(subordinate);
          }
        }
      }
      totalImportance += currentImportance;
    }
    return totalImportance;
  }

  public static void main(String[] args) {

  }
}
