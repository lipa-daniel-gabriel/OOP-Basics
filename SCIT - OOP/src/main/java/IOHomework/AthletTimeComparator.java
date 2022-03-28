package IOHomework;

import java.util.Comparator;

public class AthletTimeComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        if (o2.getAthletTimeAfterPenalties() < o1.getAthletTimeAfterPenalties()) {
            return 1;
        }
        return 0;
    }
}