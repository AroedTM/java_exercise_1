import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            else if(chaine.equals("freq"))
            {
                System.out.println("Entrer le path du fichier a analyser :");
                String path = scanner.nextLine();
                Path file = Paths.get(path);
                try
                {
                    String text = Files.readString(file);
                    text = text.toLowerCase();
                    text = text.replaceAll(",", "");
                    text = text.replaceAll("\\.", "");
                    text = text.replaceAll(":", "");
                    text = text.replaceAll(";", "");
                    text = text.replaceAll("!", "");
                    String[] tab = text.split(" ");
                    Stream<String> stream = Arrays.stream(tab);

                    Map<String, Long> result =
                            stream.collect(
                                    Collectors.groupingBy(
                                            Function.identity(), Collectors.counting()
                                    )
                            );

                    Map<String, Long> result2 =
                            result.entrySet().stream().sorted(
                                    Map.Entry.<String, Long>comparingByValue().reversed())
                            .collect(
                                    Collectors.toMap(
                                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new
                                    )
                            );

                    StringBuilder result3 = new StringBuilder();
                    int cpt = 0;
                    for (String keys : result2.keySet())
                    {
                        if(cpt != 2) {
                            result3.append(keys).append(" ");
                        }
                        else{
                            result3.append(keys);
                        }
                        cpt++;
                        if(cpt == 3)
                            break;
                    }
                    System.out.println(result3);
                }
                catch(IOException e)
                {
                    System.out.println("Unreadable file: ");
                    e.printStackTrace();
                }
                chaine = "quit";
            }
            else{
                System.out.println("Unknown command");
                chaine = scanner.nextLine();
            }
        }
    }
}