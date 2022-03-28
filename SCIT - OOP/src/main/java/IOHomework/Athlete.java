package IOHomework;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Athlete extends SkiBiathlon {
    private String number;
    private String name;
    private String countryCode;
    private String skiTimeResult;
    private String fistShootingRangeL;
    private String secondShootingRangeL;
    private String thirdShootingRangeL;
    private String minutes;
    private String seconds;
    private int skiTimeResultinSeconds;
    private int penalties;
    private int athletTimeAfterPenalties;
    private String skitTimeFinalResult;



    public Athlete(String line) {
        String[] args = line.split(",");
        number = args[0];
        name = args[1];
        countryCode = args[2];
        skiTimeResult = args[3];
        fistShootingRangeL = args[4];
        secondShootingRangeL = args[5];
        thirdShootingRangeL = args[6];
    }


    @Override
    public String toString() {
        return name +"("+ countryCode + ") " + athletTimeAfterPenalties + " " + skitTimeFinalResult + " (" + skiTimeResult + " + " + penalties + ")";
    }

}

