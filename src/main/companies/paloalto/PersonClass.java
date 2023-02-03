package main.companies.paloalto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 1) Merge list1 and list2 without duplicates
 * 2) groupby id
 * 3)
 */
public class PersonClass {

    public static void main(String[] args) {
        List<Person> p1 = new ArrayList<>();
        p1.add(new Person(1,"one",1));
        p1.add(new Person(2,"two",2));
        p1.add(new Person(3,"three",5));

        List<Person> p2 = new ArrayList<>();
        p2.add(new Person(1,"four",4));
        p2.add(new Person(2,"two",2));
        p2.add(new Person(3,"five",5));

        p1.addAll(p2);
        List<Person> uniquePerson = p1.stream().distinct().collect(Collectors.toList());
        System.out.println(uniquePerson);

        System.out.println(new ArrayList<>(uniquePerson.stream().collect(Collectors.groupingBy(Person::getId)).entrySet().stream().toList()));


    }





}

class Person {
    Integer id;
    String name;
    Integer makeId;


    public Person(Integer id, String name, Integer makeId) {
        this.id = id;
        this.name = name;
        this.makeId = makeId;
    }

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

    public Integer getMakeId() {
        return makeId;
    }

    public void setMakeId(Integer makeId) {
        this.makeId = makeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) && getName().equals(person.getName()) && getMakeId().equals(person.getMakeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMakeId());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", makeId=" + makeId +
                '}';
    }
}
