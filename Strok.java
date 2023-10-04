
import java.util.InputMismatchException;
import java.util.Scanner;

public class Strok {
    static String resultat, operation,Output1;
    public static void main(String[] args) {
        System.out.println("Введите выражение  типа: 100 + 500 или Hi World! - World!, Bye-bye! - World!, Java * 5, Example!!! / 3");
        System.out.println("Используйте пробелы перед вводом последующих элементов и двойные ковычки в начале и в конце строки");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int p = 0; p < str.length(); p++){
            switch (String.valueOf(str.charAt(p))){
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
        if (element1.length()> 10 ){
            throw new InputMismatchException("Введенно более 10 символов в строку 1");}
        String element2 = array[2].replaceAll("\"", "");
        if (element2.length()> 10 ){
            throw new InputMismatchException("Введенно более 10 символов в строку 2");}
        switch (operation) {
            case "+":
                resultat = element1.concat(element2);
                String Output = resultat.replaceAll(" ", "");
                System.out.println(Output);
                if (Output.length() > 40) {
                    System.out.println(Output.substring(0, 40) + "...");
                }
                break;
            case "*":
                int type = Integer.parseInt(element2.trim());
                Output1 = element1.repeat(type).replaceAll(" ", "");
                if (type > 10 || type == 0) {
                    throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");
                }
                if (Output1.length() > 40) {
                    String res = Output1.substring(0, 40);
                    System.out.println(res + "...");
                } else {
                    System.out.print(element1.repeat(type).replaceAll(" ", ""));
                }
                break;

            case "-":
                resultat = element1.replaceAll(" ", "");
                System.out.println(resultat);
                break;
            case "/":
                int type2 = Integer.parseInt(element2);
                if (type2 > 10 || type2 <= 0) {
                    throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");
                }
                System.out.println(element1.substring(0, type2));
                break;
        }
        }
    }
