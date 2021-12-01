import java.util.Scanner;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Suite de Fibonacci. Entrer un nombre :");
        int nombre = scanner.nextInt();
        String retour = scanner.nextLine();
        int F_0 = 0;
        int F_1 = 1;
        int F_X = 0;
        for(int i=2; i<=nombre; i++)
        {
            F_X = F_0 + F_1;
            F_0 = F_1;
            F_1 = F_X;
        }
        System.out.print("F(" + nombre + ") = " + F_X);
        return true;
    }
}