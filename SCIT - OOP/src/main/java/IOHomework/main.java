package IOHomework;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SkiBiathlon skiBiathlon = new SkiBiathlon();
        skiBiathlon.fileReader(new File("src/main/resources/skiBiathlon.csv"));
        skiBiathlon.transformAthletTimeInSeconds();
        skiBiathlon.penaltiesCalculator();
        skiBiathlon.athletTimeAfterPenalties();
        skiBiathlon.secondsToMinutes();
        skiBiathlon.podiumPositions();
    }
}
