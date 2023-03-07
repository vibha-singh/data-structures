package main.companies;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MorganStanley {
    public static void main(String[] args) {
        Map<Employee, Integer> map = new HashMap<>();
        Employee e = new Employee();
        e.setId(1);
        e.setName("Vibha");
        map.put(e,1);
        map.put(e,1);
        System.out.println(map.size());
        //Collections.synchronizedList()

//        ExecutorService e = Executors.
    }
}

class Employee {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return false;
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//        Employee employee = (Employee) o;
//        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return 1;

                //Objects.hash(id, name);
    }
}
