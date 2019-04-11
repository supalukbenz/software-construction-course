package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class CurrentConditionDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;

    public CurrentConditionDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Current Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/3-frame.getSize().width/3, dim.height/2-frame.getSize().height/2);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.PINK);
        area.setText("Current Condition:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        area.setBackground(Color.PINK);
        area.setText("Current Condition:\n\n");
        area.append("Temperature = "+temp+"\n");
        area.append("Humidity = "+humid+"\n");
        area.append("Pressure = "+pressure+"\n");
    }
}
