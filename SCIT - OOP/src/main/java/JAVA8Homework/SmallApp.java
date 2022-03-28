package JAVA8Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallApp {
    List<Person> personList = new ArrayList<>();
    List<String> personListName = new ArrayList<>();


    /**
     *Method that set the atributes of a new Object from class Person
     * @return
     */
    public Person retrieveAthletFromString(String row) {

        Person person = new Person();
        Scanner s = new Scanner(row);
        s.useDelimiter(",");
        if (s.hasNext()) {
            person.setFirstName(s.next());
            person.setLastName(s.next());
            person.setDateOfBirth(s.next());
        }
        return person;
    }
    /**
     * Method that read the .csv file and add persons to a list
     * @throws IOException
     */
    public List<Person> copyAthletsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String row;

            while ((row = reader.readLine()) != null) {
                Person person = retrieveAthletFromString(row);
                personList.add(person);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return personList;
    }

    /**
     * Method that write a new file.csv only with First and Last name
     * @throws IOException
     */
    public void writeFirstNameAndLastName(String fileName) throws IOException {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
        }
        methodthatAddLastAndFirstNametoANewList();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String person : personListName) {
                bufferedWriter.write(person);
                bufferedWriter.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method that extract persons with a specific birth month and sort them by name
     * @param month
     */
    public void monthFromBirthDay(String month) {
        switch (month){
            case "01":
                System.out.println("List of persons born in month: " +month+"(January)");
                break;
            case "02":
                System.out.println("List of persons born in month: " +month+"(February)");
                break;
            case "03":
                System.out.println("List of persons born in month: " +month+"(March)");
                break;
            case "04":
                System.out.println("List of persons born in month: " +month+"(April)");
                break;
            case "05":
                System.out.println("List of persons born in month: " +month+"(May)");
                break;
            case "06":
                System.out.println("List of persons born in month: " +month+"(June)");
                break;
            case "07":
                System.out.println("List of persons born in month: " +month+"(July)");
                break;
            case "08":
                System.out.println("List of persons born in month: " +month+"(August)");
                break;
            case "09":
                System.out.println("List of persons born in month: " +month+"(September)");
                break;
            case "10":
                System.out.println("List of persons born in month: " +month+"(October)");
                break;
            case "11":
                System.out.println("List of persons born in month: " +month+"(November)");
                break;
            case "12":
                System.out.println("List of persons born in month: " +month+"(December)");
                break;
            default:
            System.out.println("Invalid month");
        }
        List<Person> sortedPersonLsit = new ArrayList<>();
        for (Person person : personList) {
            String[] dateSpliter = person.getDateOfBirth().split("\\.");
            person.setDateOfBirth(dateSpliter[1]);
            if (person.getDateOfBirth().equals(month)) {
                sortedPersonLsit.add(person);
                System.out.println("Persoana: " + person.getFirstName() + "-" + person.getLastName() + " s-a nascut in luna: " + month);
            }
        }
        System.out.println("Sorted list by name: ");
        Collections.sort(sortedPersonLsit, new DateComparator());
        for (Person person1 : sortedPersonLsit) {
            System.out.println(person1);
        }
    }

    /**
     * Method that add to a list only First and Last name
     */
    private void methodthatAddLastAndFirstNametoANewList() {
        for (Person person : personList) {
            personListName.add(person.getFirstName() + "-" + person.getLastName());
        }
    }

}
