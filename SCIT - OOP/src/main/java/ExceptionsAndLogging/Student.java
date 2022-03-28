package ExceptionsAndLogging;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private int dateOfBirth;
    private int id;
    private List<Student> studentList = new ArrayList<>();

    public Student(String firstName, String lastName, int dateOfBirth, String gender, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public Student() {
    }

    /**
     * Method that add a student if validation is acquired
     */

    public void addStudent(String firstName,String lastName,int dateOfBirth,String gender,int id) {
        Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
        try {
            studentList.add(student);
            validate(student);
        } catch (ValidationException e) {
            if (e.getErrorCode().equals("year")) {
                System.out.println("date of birth between 1900 and current year, student not added to the student list");
                studentList.remove(student);
            }
            if (e.getErrorCode().equals("name")) {
                System.out.println("first name or last name is empty, student not added to the student list");
                studentList.remove(student);
            }
            if (e.getErrorCode().equals("gender")) {
                System.out.println("gender its not male or female, student not added to the student list");
                studentList.remove(student);
            }
        }
    }

    /**
     * Method that delete a student from a list by ID
     *
     * @return the new list
     */

    public List<Student> deleteStudentByID(int ID) {
        try {
            for (Student student : studentList) {
                if (student.getId() == ID) {
                    studentList.remove(student);
                    System.out.println("Studentul: " + student.getFirstName() + " cu id-ul " + ID + " a fost sters");
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        return studentList;
    }

    /**
     * Method that return a list of students with a specific age
     */

    public List<Student> retriveAllStudentsWithASpecificAge(int age) {
        List<Student> studentListWithSpecificAge = new ArrayList<>();
        try {
            if (age <= 0 || age > 118)
                throw new ValidationException("Age is <0 or Age >118", "age");
            for (Student student : studentList) {
                if (student.getDateOfBirth() == (2021 - age))
                    System.out.println(student + " are varsta de: " + age + " ani");
                studentListWithSpecificAge.add(student);
            }
        } catch (ValidationException e) {
            if (e.getErrorCode().equals("age")) {
                System.out.println("date of birth between 1900 and current year");
            }
        }
        return studentListWithSpecificAge;
    }

    /**
     * Method that throw an NumberFormatException
     */

    public void retriveAllStudentsWithASpecificAge(String age) {
        try {
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Number format not accepted");
        }
    }

    /**
     * Method created for addStudent validation
     */

    private static void validate(Student student) throws ValidationException {
        if (student.dateOfBirth < 1900 || student.dateOfBirth > 2021) {
            throw new ValidationException("date of birth between 1900 and current year", "year");
        }
        if (student.firstName == null || student.lastName == null) {
            throw new ValidationException("first name or last name is empty", "name");
        }
        if (!student.gender.equalsIgnoreCase("M") && !student.gender.equalsIgnoreCase("F")) {
            throw new ValidationException("gender its not male or female", "gender");
        }
    }

    @Override
    public String toString() {
        return "Student: " +
                "firstName:" + firstName + '\'' +
                ", lastName:" + lastName + '\'' +
                ", dateOfBirth:" + dateOfBirth +
                ", gender:" + gender + '\'' +
                ", id:" + id;
    }


    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void displaySudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public String getFirstName() {
        return firstName;
    }
}


