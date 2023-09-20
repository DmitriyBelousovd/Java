import java.util.InputMismatchException;
import java.util.Scanner;

class KataTest {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2, result;


    static char operator;

    public static void main(String[] args) {
        System.out.println("Введите  выражение [2 + 2] от 1 до 10 или два римских числа от I до X:[V + V] и нажмите Enter ");
        String userInput = scanner.nextLine();
        args = userInput.split(" ");
        if (userInput.length() > 7) {
            throw new InputMismatchException("В ведено более двух операндов");
        }
        operator = userInput.charAt(userInput.indexOf(args[1]));
        String args0 = (args[0]);
        String args2 = (args[2]);
        String type1;
        String type2;
        try {
            Integer.parseInt(args0);
            type1 = "АРАБ";
        } catch (Throwable e) {
            type1 = "РИМ";
        }
        try {
            Integer.parseInt(args2);
            type2 = "АРАБ";
        } catch (Throwable e) {
            type2 = "РИМ";
        }
        num1 = romanToNumber(args0);
        num2 = romanToNumber(args2);
        if (num1 > 10  || num2 > 10 || num1 <= 0 || num2 <= 0 ) {
            throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");
        }
        if (type1.equals("АРАБ") && type2.equals("АРАБ")) {
            result = calculated(result);
            System.out.println( result);
        } else if (type1.equals("РИМ") && type2.equals("РИМ")) {
            result = calculated( result);
            if (result <= 0 ) {
                throw new InputMismatchException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            }
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
        } else {
            throw new InputMismatchException("Арабские и римские числа не совместимы");
        }

    }

    private static int romanToNumber(String roman) {
        try {
            return switch (roman) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> throw new InputMismatchException();
            };
        } catch (InputMismatchException e) {
            return Integer.parseInt(roman);
        }
    }

    public static int calculated(int result) {
        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("На ноль делить нельзя");
                }
            }
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"null","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}