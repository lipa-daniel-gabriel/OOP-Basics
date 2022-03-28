package JAVA8Homework;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SmallApp smallApp = new SmallApp();
        smallApp.copyAthletsFromFile("src/main/resources/first,last,dateOfBirth.csv");
        smallApp.writeFirstNameAndLastName("src/main/resources/first&lastName.csv");
        smallApp.monthFromBirthDay("05");
    }
}