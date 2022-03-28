package TemaObjectContainer;

import java.util.Comparator;

/**
 * Class that executes name comparator
 */
public class PersonComparedByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
