package IOHomework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SkiBiathlon {
    List<Athlete> athleteList = new ArrayList<>();

    /**
     * Method that read from a file and set Athlet atributes
     * @throws IOException
     */

    public void fileReader(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Athlete athlete = new Athlete(line);
            athleteList.add(athlete);
        }
    }

    /**
     * Method that set athlet time after penalties
     */
    public void athletTimeAfterPenalties() {
        for (Athlete athlete : athleteList) {
            athlete.setAthletTimeAfterPenalties(athlete.getSkiTimeResultinSeconds() + athlete.getPenalties());
        }
    }

    /**
     * Method that sort a list by time and put it in a map that show the podium positions
     */

    public void podiumPositions() {

        Map<String, Athlete> top3 = new HashMap<>();
        Collections.sort(athleteList, new AthletTimeComparator());
        top3.put("Third Place :", athleteList.get(0));
        top3.put("Runner-up :", athleteList.get(1));
        top3.put("Winner :", athleteList.get(2));

        for (Map.Entry<String, Athlete> entry : top3.entrySet())
            System.out.println(entry.getKey() + entry.getValue());
    }

    /**
     * Method that transform athlet time berfore penalties in seconds
     */

    public void transformAthletTimeInSeconds() {
        for (Athlete athlete : athleteList) {
            int result = 0;
            String line = athlete.getSkiTimeResult().toString();
            String[] timeConvertor = line.split(":");
            athlete.setMinutes(timeConvertor[0]);
            athlete.setSeconds(timeConvertor[1]);

            for (int i = 0; i < timeConvertor.length; i++) {
                switch (i) {
                    case 0:
                        result += Integer.parseInt(athlete.getMinutes()) * 60;
                        continue;
                    case 1:
                        result += Integer.parseInt(athlete.getSeconds()) * 1;
                        continue;
                }
            }
            athlete.setSkiTimeResultinSeconds(result);
        }
    }

    /**
     * Method that combine all 3 shooting ranges and count the number of misses
     */
    public void penaltiesCalculator() {

        for (Athlete athlete : athleteList) {
            int count = 0;
            String line = athlete.getFistShootingRangeL() + athlete.getSecondShootingRangeL() + athlete.getThirdShootingRangeL();
            String[] penalties = line.split("");
            for (int i = 0; i < penalties.length; i++) {
                if (penalties[i].equals("o")) {
                    count++;
                }
            }
            athlete.setPenalties(count * 10);
        }
    }

    /**
     * Method that transform the final time (time before penalties + penalties) in minutes
     */


    public void secondsToMinutes() {
        for (Athlete athlete : athleteList) {
            int minutes = 0;
            int seconds = 0;
            double value = athlete.getAthletTimeAfterPenalties();
            String line = String.valueOf(value / 60);
            String[] finalTime = line.split("\\.");
            athlete.setMinutes(finalTime[0]);
            athlete.setSeconds(finalTime[1]);
            for (int i = 0; i < finalTime.length; i++) {
                switch (i) {
                    case 0:
                        minutes = Integer.parseInt(athlete.getMinutes());
                        continue;
                    case 1:
                        seconds = (int) (Integer.parseInt(athlete.getSeconds()) * 0.6);
                        continue;
                }
            }
            athlete.setSkitTimeFinalResult(minutes + ":" + seconds);
        }
    }
}