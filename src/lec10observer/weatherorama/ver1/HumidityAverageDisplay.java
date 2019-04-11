package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {

    private double prevTemp;

    private JFrame frame;
    private JTextArea area;

    public HumidityAverageDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Humidity Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/5-frame.getSize().height/5);
        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.BLUE);
        area.setText("Humidity Average Condition:\n");


    }

    @Override
    public void update(double temp, double humid, double pressure) {
        if (prevTemp == 0)
            prevTemp = humid;
        double avg = (prevTemp + humid)/2;
        prevTemp = avg;

        area.setBackground(Color.BLUE);
        area.setText("Average Condition:\n");
        area.append("Humidity = "+avg);

    }
}
