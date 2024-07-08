package fran;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    final String STEPPER = "stepper.00";
    final String MOVE = STEPPER + "_move_2000_1";
    final String STOP = STEPPER + "_stop";
    final String RESET = STEPPER + "_move_-2000_1";
    final String SHARPEN = STEPPER + "_move_200_1; dc.00_move_800";
    final String ROTATE = "dc.00_move_1500";
    final String AUTO_SHARPEN = STEPPER + "_speed_1000|"+ STEPPER +"_move_4300_1|"+ STEPPER +"_speed_400;" + STEPPER + "_move_3400_1;dc.00_move_9000|"+ STEPPER + "_speed_1000|" + STEPPER + "_move_-6900_1";

    MqttConnector mqtt = new MqttConnector("ws://mqtt.hextronics.cloud:8083/mqtt", "hextech-frank", "frank");
    String mqttTopic = "hextech/hextech-frank/commands";

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        App app = new App();
    }

    public App() {
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);

        button1 = new JButton("MOVE");
        button1.setPreferredSize(new Dimension(150, 50));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                mqtt.publishMessage(mqttTopic, MOVE);
            }
        });

        button2 = new JButton("RESET");
        button2.setPreferredSize(new Dimension(150, 50));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mqtt.publishMessage(mqttTopic, RESET);
            }
        });

        button3 = new JButton("SHARPEN");
        button3.setPreferredSize(new Dimension(150, 50));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mqtt.publishMessage(mqttTopic, SHARPEN);
            }
        });

        button4 = new JButton("AUTOSHARPEN");
        button4.setPreferredSize(new Dimension(150, 50));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mqtt.publishMessage(mqttTopic, AUTO_SHARPEN);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(button1, gbc);

        gbc.gridy = 1;
        this.add(button2, gbc);

        gbc.gridy = 2;
        this.add(button3, gbc);

        gbc.gridy = 3;
        this.add(button4, gbc);

        this.pack();
        this.setVisible(true);
    }
}
