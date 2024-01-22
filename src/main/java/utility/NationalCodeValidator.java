package utility;

import java.util.Arrays;

public class NationalCodeValidator {

    public static boolean isNationalCodeValid(String melliCode) {

        String[] identicalDigits = {"0000000000", "1111111111", "2222222222", "3333333333", "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999"};

        if (melliCode.trim().isEmpty()) {

            System.out.println("National Code is empty");
            return false; // National Code is empty

        } else if (melliCode.length() != 10) {

            System.out.println("National Code must be exactly 10 digits");
            return false; // National Code is less or more than 10 digits

        } else if (Arrays.asList(identicalDigits).contains(melliCode)) {

            System.out.println("MelliCode is not valid (Fake MelliCode)");
            return false; // Fake National Code

        } else {
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(melliCode.charAt(i)) * (10 - i);
            }

            int lastDigit;
            int divideRemaining = sum % 11;

            if (divideRemaining < 2) {
                lastDigit = divideRemaining;
            } else {
                lastDigit = 11 - (divideRemaining);
            }

            if (Character.getNumericValue(melliCode.charAt(9)) == lastDigit) {
                System.out.println("MelliCode is valid");
                return true;
            } else {
                System.out.println("MelliCode is not valid");
                return false; // Invalid MelliCode
            }
        }
    }
}

    /*public static boolean isNationalCodeValid(String nationalCode) {
        if (nationalCode == null || !nationalCode.matches("\\d{10}")) {
            return false; // National code should be exactly 10 digits
        }

        int[] coefficients = {29, 27, 23, 19, 17, 29, 27, 23, 19, 17};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(nationalCode.charAt(i)) * coefficients[i];
        }

        int remainder = sum % 11;
        int controlDigit = (remainder < 2) ? remainder : 11 - remainder;

        return controlDigit == Character.getNumericValue(nationalCode.charAt(9));
    }

}*/

