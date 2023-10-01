import java.util.Scanner;

public class main {
    static String resultat;
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replaceAll("\"","");
        String[]arrray = str.split(" ");
        String element1 = arrray[0];
        String element2 = arrray[2];
        char operator = str.charAt(str.indexOf(arrray[1]));
        switch (operator){
            case '+': resultat = element1.concat(element2);
                System.out.println(resultat);
            case '*': int type=Integer.parseInt(arrray[2]);
            for (int i = 0;i < type;i++) {
                System.out.print(element1);
            }
            case '-':  resultat = ;
        }


    }
}