import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) employees.length
// MC: O(N)
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    public static int importance = 0;
    public static Map<Integer, Employee> emp_map = new HashMap();;

    public static int dfs(int id) {
        Employee curr_emp = emp_map.get(id);
        
        importance = curr_emp.importance;

        for (Integer i : curr_emp.subordinates) {
            importance += dfs(i);
        };
        return importance;
    }

    public static int getImportance(List<Employee> employees, int id) {
        if (employees == null) return 0;
        for(Employee e : employees) emp_map.put(e.id, e);
        return dfs(id);
    }
}
