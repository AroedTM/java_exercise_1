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

public class Freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
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
        return true;
    }
}