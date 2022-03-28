package ExceptionsAndLogging;

public class Main {
    public static void main(String[] args) {


        Student studenti = new Student();
        studenti.addStudent("Exception", "Validation", 2015, "avion", 199929);
        studenti.addStudent("Lipa", "Daniel", 2015, "M", 199929);
        studenti.addStudent("Mihai", "Alin", 2010, "f", 19999);
        studenti.addStudent("Ion", "Adrian", 2000, "F", 199992);
        studenti.addStudent("Marcel", "Alex", 1900, "m", 199993);
        studenti.displaySudents();
        studenti.deleteStudentByID(199993);
        studenti.displaySudents();
        studenti.retriveAllStudentsWithASpecificAge(11);
        studenti.retriveAllStudentsWithASpecificAge("11");
    }
}
