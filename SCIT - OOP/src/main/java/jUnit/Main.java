package jUnit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        String expressionInput = scanner.nextLine();

        double result = calculator.expresionCalculatedInMM(expressionInput);
        System.out.println("Rezultatul ecuatiei: " + expressionInput + " este: " + result + " mm");
    }

}
