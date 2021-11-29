import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Bienvenue. Entrer qqchose :");
        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();
        if(!chaine.equals("quit"))
        {
            System.out.println("Unknown command");
        }
    }
}