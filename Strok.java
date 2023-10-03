
import java.util.Scanner;

public class Strok {
    static String resultat, operation;
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
        String element2 = array[2].replaceAll("\"", "");
        switch (operation) {
            case "+":
                resultat = element1.concat(element2);
                System.out.println(resultat.replaceAll(" ", ""));
                break;
            case "*":
                int type = Integer.parseInt(element2.trim());
                System.out.print(element1.repeat(type).replaceAll(" ", ""));
                break;
            case "-":
                    resultat = element1.replaceAll(" ", "");
                    System.out.println(resultat);
                    break;
            case "/":
                System.out.println(element1.substring(0,Integer.parseInt(element2)));
                break;

                }
        }
    }
