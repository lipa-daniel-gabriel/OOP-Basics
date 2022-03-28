package jUnit;

public class Calculator {

    /**
     * Method that calculate keyboard typed expression
     * @param nextLine read what we type on keyboard and split it by regex "\\s+"
     * After split, splited values are storest in splitedNumbers
     * @return
     */
    public static double expresionCalculatedInMM(String nextLine) {
        double result = 0;
        boolean hasNextPlus = true;
        boolean hasNextMinus = false;
        String[] splitedNumbers = nextLine.split("\\s+");

        for (int i = 0; i < splitedNumbers.length; i++) {

            switch (splitedNumbers[i]) {
                case "+":
                    hasNextPlus = true;
                    hasNextMinus = false;
                    break;
                case "-":
                    hasNextMinus = true;
                    hasNextPlus = false;
                    break;
            }

            result = returnResultUsingBooleanToDecideIfNextIsPlusOrMinus(result, hasNextPlus, hasNextMinus, splitedNumbers, i);
        }
        return result;
    }

    /**
     * Method that convert input number in mm
     *
     * @return a result (mm converted number)
     */
    public static double unitConversion(int numar, String measurementUnit) {
        double result = 0;
        switch (measurementUnit) {
            case "mm":
                result = numar;
                break;
            case "cm":
                result = numar * 10;
                break;
            case "m":
                result = numar * 1000;
                break;
            default:
                System.out.println("Invalid measurement unit");
        }
        return result;
    }

    /**
     * Method that check if after the number we have + or - using boolean and add and subtract add and subtract depending on the conclusion given by boolean
     *
     * @return final result
     */
    private static double returnResultUsingBooleanToDecideIfNextIsPlusOrMinus(double result, boolean hasNextPlus, boolean hasNextMinus, String[] splitedNumbers, int i) {
        if (measurementUnitsCheck(splitedNumbers[i])) {
            if (hasNextPlus) {
                result += unitConversion(Integer.valueOf(splitedNumbers[i - 1]), splitedNumbers[i]);
            } else if (hasNextMinus) {
                result -= unitConversion(Integer.valueOf(splitedNumbers[i - 1]), splitedNumbers[i]);
            }
        }
        return result;
    }

    /**
     * Method that show the accepted unit of measure
     *
     * @param splitedNumbers
     * @return
     */
    public static boolean measurementUnitsCheck(String splitedNumbers) {
        return splitedNumbers.equals("cm") || splitedNumbers.equals("mm") || splitedNumbers.equals("m");
    }

}
