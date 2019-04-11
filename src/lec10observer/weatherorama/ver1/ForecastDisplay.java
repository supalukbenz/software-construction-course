package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer{

    private double prevTemp;

    private JFrame frame;
    private JTextArea area;

    public ForecastDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.GRAY);
        area.setText("Forecast:\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        if (prevTemp == 0)
            prevTemp = temp;
        double avg = (prevTemp + temp)/2;
        prevTemp = avg;

        double forecast = temp;
        double avgTempPerHr = prevTemp/24;
        if(prevTemp < temp) forecast -= avgTempPerHr;
        else if(prevTemp > temp) forecast += avgTempPerHr;

        area.setBackground(Color.GRAY);
        area.setText("Forecast:\n");
        area.append("Forecast Temperature = " + forecast);
    }
}
