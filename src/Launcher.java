import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Command> command_list = List.of(
                new Fibo(),
                new Freq(),
                new Quit()
        );

        System.out.println("Bienvenue. Entrer qqchose :");

        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();

        boolean result = false;

        do{
            for(Command command : command_list)
            {
                if(chaine.equals(command.name()))
                {
                    result = command.run(scanner);
                }
            }
            if(!result) {
                System.out.println("Unknown command");
                chaine = scanner.nextLine();
            }
        }while(!result);

    }
}