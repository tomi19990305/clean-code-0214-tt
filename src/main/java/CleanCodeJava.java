import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CleanCodeJava {

    public static void main(String[] args) {
        System.out.println(getMinimumDifference(loadWeatherDaysFromFile("src/main/resources/datamunging/weather.dat")));
    }

    public static int getMinimumDifference(List<WeatherOfDay> weatherOfDays) {
        return weatherOfDays.stream()
                .min((o1, o2) -> {
                    Double d1 = o1.differenceBetweenMinAndMaxTemp();
                    Double d2 = o2.differenceBetweenMinAndMaxTemp();
                    return d1.compareTo(d2);
                }).get().getDayNumber();
    }

    public static List<WeatherOfDay> loadWeatherDaysFromFile(String fileName) {
        List<WeatherOfDay> weatherOfDays = new ArrayList<>();

        List<String> linesOfFile = readFileInList(fileName);
        for (int i = 2; i < linesOfFile.size() - 1; ++i) {
            weatherOfDays.add(new WeatherOfDay(linesOfFile.get(i)));
        }

        return weatherOfDays;
    }

    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
