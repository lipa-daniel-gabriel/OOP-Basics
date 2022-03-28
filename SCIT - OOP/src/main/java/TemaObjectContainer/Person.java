package TemaObjectContainer;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int age;
    private String name;
    private List<Hobby> hobbyList = new ArrayList<>();


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Persoana{" +
                "age=" + age +
                ", name='" + name;

    }
}

