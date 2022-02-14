import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CleanCodeJava {
    public static void main(String[] args)
    {
        List<String> l = readFileInList("src/main/resources/datamunging/weather.dat");

        int min = 0;
        String dayNumberOfMin = null;

        for(int i=2; i< l.size()-1; ++i){
            String[] cols = l.get(i).split("\\s+");
            String dayNumber = cols[1];
            int maxOfTheDay = Integer.parseInt(cols[2].replaceAll("[^\\d.]", ""));
            int minOfTheDay = Integer.parseInt(cols[3].replaceAll("[^\\d.]", ""));

            if(dayNumberOfMin==null){
                min = maxOfTheDay-minOfTheDay;
                dayNumberOfMin = dayNumber;
            }else{
                if(maxOfTheDay-minOfTheDay < min){
                    min = maxOfTheDay-minOfTheDay;
                    dayNumberOfMin = dayNumber;
                }
            }
        }

        System.out.println(dayNumberOfMin);
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
