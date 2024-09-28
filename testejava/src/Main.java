import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int x;
        double y;
        String nome;
        x = sc.nextInt();
        y = sc.nextDouble();
        sc.nextLine();
        nome = sc.nextLine();
        System.out.println("x = "+x);
        System.out.printf("y = %.1f%n",y);
        System.out.printf("nome = %s\n",nome);
        System.out.println("x = " + x + "\ny = " + y + "\nnome = "+ nome);
        boolean a = true;
        //System.in.read(x);
        if (!a){
            System.out.println("A");
        }else {
            System.out.println("B");
        }
        sc.close();
    }
}
