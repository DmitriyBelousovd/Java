
import java.util.InputMismatchException;
import java.util.Scanner;

public class Strok {
    public static String resultat, operation, element2, element1, Output,str, res;


    public static void main(String[] args) {
        System.out.println("Введите выражение  типа: 100 + 500 или Hi World! - World!, Bye-bye! - World!, Java * 5, Example!!! / 3");
        System.out.println("Используйте пробелы перед вводом последующих элементов и двойные ковычки в начале и в конце строки");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int p = 0; p < str.length(); p++) {
            switch (String.valueOf(str.charAt(p))) {
                case "+" -> operation = "+";
                case "-" -> operation = "-";
                case "*" -> operation = "*";
                case "/" -> operation = "/";
            }
        }
        String[] array = str.split(" ");
        String element1 = array[0].replaceAll("\"", "");
        if (operation == null) {
            throw new IllegalArgumentException("ввод пользователем выражения, не соответствующего одной из вышеописанных арифметических операций");
        }
        if (element1.length() > 10) {
            throw new InputMismatchException("Введенно более 10 символов в строку 1");
        }
        String element2 = array[2].replaceAll("\"", "");
        if (element2.length() > 10) {
            throw new InputMismatchException("Введенно более 10 символов в строку 2");
        }
         switch (operation){
            case "-":
                String[] ar = str.split(" - ");
                String num1 = ar[0].replaceAll("\"", "");
                if (num1.length() > 10) {
                    throw new InputMismatchException("Введенно более 10 символов в строку 1");
                }
                String num2 = ar[1].replaceAll("\"", "");
                if (num2.length() > 10) {
                    throw new InputMismatchException("Введенно более 10 символов в строку 1");
                }
                String resultat1 = num1.replaceFirst(num2, "");
                System.out.println(resultat1.trim());
                break;
             case "*":
                 int type = Integer.parseInt(element2.trim());
                 String Output1 = element1.repeat(type).replaceAll(" ", "");
                 if (type > 10 || type == 0) {
                     throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");
                 }
                 if (Output1.length() > 40) {
                     resultat = Output1.substring(0, 40);
                     System.out.println(resultat + "...");
                 } else {
                     System.out.println(element1.repeat(type).replaceAll(" ", ""));
                 }
                 break;

             default: System.out.println(Conclusion(resultat,element1,element2));
        }
    }

    private static String Conclusion(String resultat,String element1, String element2) {
        switch (operation) {
            case "+":
                resultat = element1.concat(element2);
                if (resultat.length() > 40) {
                    System.out.println(resultat.substring(0, 40) + "...");
                }
                break;
            case "/":
                int type2 = Integer.parseInt(element2);
                if (type2 > 10 || type2 <= 0) {
                    throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");
                }
                resultat = element1.substring(0, type2 + 2);
                break;
        }
        return resultat;
    }
}
