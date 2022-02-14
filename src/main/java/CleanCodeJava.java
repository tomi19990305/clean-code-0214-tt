import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CleanCodeJava {
    public static void main(String[] args)
    {
        List l = readFileInList("src/main/resources/datamunging/weather.dat");

        System.out.println(l.get(2));
        for(int i=2; i< l.size()-1; ++i){
            System.out.println(l.get(i));
        }
    }


    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }
}
