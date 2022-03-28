package TemaObjectContainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Interface that help us create a set
         * @add add element to the set
         */
        Set<Person> personList = new TreeSet<>(new PersonComparedByAge());
        personList.add(new Person("Mihai", 19));
        personList.add(new Person("George", 10));
        personList.add(new Person("Alin", 32));
        personList.add(new Person("Alex", 15));
        System.out.println(personList);

        Map<Person, List<Hobby>> personListMap = new HashMap<Person, List<Hobby>>();

        /**
         * Interface that help us create a list
         * @add add element to the list
         * @put put element in map
         * */
        List<Hobby> hobbyList1 = new ArrayList<>();
        hobbyList1.add(new Hobby("Ciclyng", 10, "Strada1"));
        hobbyList1.add(new Hobby("swimming", 15, "Strada2"));
        personListMap.put(new Person("Mihai", 10), hobbyList1);
        /**
         * Interface that help us create a list
         * @add add element to the list
         * @put put element in map
         */
        List<Hobby> hobbyList2 = new ArrayList<>();
        hobbyList2.add(new Hobby("Gaming", 27, "Strada3"));
        hobbyList2.add(new Hobby("swimming", 25, "Strada4"));
        personListMap.put(new Person("George", 43), hobbyList2);

        /**
         * for-each loop for iteration over Map
         * for-each loop for iteration over Hobby
         */
        for (Map.Entry<Person, List<Hobby>> entry : personListMap.entrySet()) {
            if (entry.getKey().getName().equals("George")) {
                for (Hobby get : entry.getValue())
                    System.out.println(get.getNameOfHobby() + " " + get.getAdressList());
            }
        }
    }
}


