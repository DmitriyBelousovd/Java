
import java.util.InputMismatchException;
import java.util.Scanner;

public class Strok {
    static String resultat, operation;
    private static int type;
    //static char operation;

    public static void main(String[] args) {
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
        if (element1.length()> 10 ){
            throw new InputMismatchException("Введенно более 10 символов в строку");}
        String element2 = array[2].replaceAll("\"", "");
        if (element2.length()> 10 ){
            throw new InputMismatchException("Введенно более 10 символов в строку");}
        switch (operation) {
            case "+":
                resultat = element1.concat(element2);
                String Output = resultat.replaceAll(" ", "");
                System.out.println(Output);
                if (Output.length() > 40) {
                    System.out.println("...");
                }
                break;
            case "*":
                try {
                    int type = Integer.parseInt(element2.trim());
                } catch (Throwable e) {
                    throw new InputMismatchException("Ошибка ввода операнда");
                }
                String Output1 = element1.repeat(type).replaceAll(" ", "");
                if (type > 10 || type <= 0) {
                    throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");}
                System.out.print(Output1);
                if (Output1.length()>=40){
                    System.out.println("...");}
                break;
            case "-":
                    resultat = element1.replaceAll(" ", "");
                    System.out.println(resultat);
                    break;
            case "/":
                int type2 = Integer.parseInt(element2);
                if (type2 > 10 || type2 <= 0) {
                    throw new InputMismatchException("Неверное значение числа, вводить числа от 1 до 10");}
                System.out.println(element1.substring(0,type2));
                break;

                }
        }
    }
