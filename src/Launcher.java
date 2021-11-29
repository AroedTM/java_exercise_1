import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Bienvenue. Entrer qqchose :");
        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();
        while(!chaine.equals("quit"))
        {
            if(chaine.equals("fibo"))
            {
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
                chaine = "quit";
            }
            else{
                System.out.println("Unknown command");
                chaine = scanner.nextLine();
            }
        }
    }
}