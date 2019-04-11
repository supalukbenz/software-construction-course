package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWaveHeight;

    private JFrame frame;
    private JTextArea weatherArea, oceanArea ;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/4-frame.getSize().width/4, dim.height/2-frame.getSize().height/2);

        weatherArea = new JTextArea(200, 200);
        weatherArea.setBackground(Color.YELLOW);
        weatherArea.setText("Average Condition:\n\n");

        oceanArea = new JTextArea(200, 200);
        oceanArea.setBackground(Color.BLUE);
        oceanArea.setText("Average Condition:\n\n");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(weatherArea);
        frame.add(oceanArea);

    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avg;

            weatherArea.setBackground(Color.YELLOW);
            weatherArea.setText("Average Condition:\n");
            weatherArea.append("Temperature = " + avg);

        }

        if (data instanceof OceanData) {
            OceanData weatherData = (OceanData) data;

            if (prevWaveHeight == 0)
                prevWaveHeight = weatherData.getWaveHeight();
            double avg = (prevWaveHeight + weatherData.getWaveHeight()) / 2;
            prevWaveHeight = avg;

            oceanArea.setBackground(Color.BLUE);
            oceanArea.setText("Average Condition:\n");
            oceanArea.append("Wave height = " + avg);
        }
    }
}
