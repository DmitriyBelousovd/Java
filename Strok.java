
import java.util.Scanner;

public class Strok {
    static String resultat, operation;
    public static void main(String[]args){
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
        String[]arrray = str.split("[+-/*]");
        String element1 = arrray[0].replaceAll("\"","");
        String element2 = arrray[2].replaceAll("\"","");
        switch (operation){
            case "+": resultat = element1.concat(element2);
                System.out.println( resultat);
            case "*": int type=Integer.parseInt(arrray[2]);
                for (int i = 0;i < type;i++) {
                    System.out.print(element1);
                }
            case "-": resultat = str.replaceAll(element2," " );
            System.out.println(resultat);
        }


    }
}