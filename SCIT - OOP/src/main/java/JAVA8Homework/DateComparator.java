package JAVA8Homework;

import java.util.Comparator;

public class DateComparator implements Comparator<Person> {
    /**
     * Method that sort a list by FirstName
     * @return
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }
}
