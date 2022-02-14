import lombok.Data;

@Data
public class WeatherOfDay {

    private int dayNumber;

    private double maxTemp;

    private double minTemp;

    public WeatherOfDay(String weatherRow) {
        String[] cols = weatherRow.split("\\s+");
        dayNumber = Integer.parseInt(cols[1]);
        maxTemp = Double.parseDouble(cols[2].replaceAll("[^\\d.]", ""));
        minTemp = Double.parseDouble(cols[3].replaceAll("[^\\d.]", ""));
    }

    public double differenceBetweenMinAndMaxTemp(){
        return maxTemp-minTemp;
    }
}
