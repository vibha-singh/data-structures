package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Assume you have list of employee in various department, Write a program to find highest paid employee from each department
 **/

class Employee {
    private Integer id;
    private String name;
    private String dept;
    private Integer salary;


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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee( Integer id, String name, String dept, Integer salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
    public static void main(String[] args) {
        List<Employee> lists = Stream.of(new Employee(1,"vibha","HR",1232543),
                new Employee(1,"rahul","soft",6576877),
                new Employee(1,"rohit","soft",12324368),
                new Employee(1,"rashmi","HR",58790046),
                new Employee(1,"bubly","Finance",23545658)).collect(Collectors.toList());

        Map<String, Optional<Employee>> empMap = lists.stream().collect(groupingBy(Employee::getDept,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(empMap);
        // Output: {Finance=Optional[Employee{id=1, name='bubly', dept='Finance', salary=23545658}], HR=Optional[Employee{id=1, name='rashmi', dept='HR', salary=58790046}], soft=Optional[Employee{id=1, name='rohit', dept='soft', salary=12324368}]}
    }
}