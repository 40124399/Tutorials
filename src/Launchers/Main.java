package Launchers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main extends JFrame {

    private JButton button;
    private JTextField textField;
    private JPanel panel;
    private Timer timer;

    private Boolean toggle = false;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        setTitle("WINDOW");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 300);

        button = new JButton("TURN ON");
        button.setBounds(30, 30, 70, 25);
        button.setBackground(Color.GREEN);

        textField = new JTextField();
        textField.setBounds(30, 60, 100, 30);

        panel = new JPanel();
        panel.setBounds(30, 95, 100, 100);
        panel.setBackground(Color.black);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                for(int i = 0; i < 10; i++) {
                    s += ","+((int)(Math.random()*230));
                }

                System.out.println(s);
                s = s.replaceFirst(",","");

                drawPanel(s);
            }
        });

        getContentPane().add(button);
        getContentPane().add(textField);
        getContentPane().add(panel);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponent(button, textField);

                panel.setBounds(panel.getX(), panel.getY(), getContentPane().getWidth() - (panel.getX() * 2), getContentPane().getHeight() - panel.getY() - 10);

                resizeComponent(button);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!toggle) {
                    timer.start();
                    toggle = true;
                    button.setBackground(Color.RED);
                    button.setText("TURN OFF");
                } else {
                    timer.stop();
                    toggle = false;
                    button.setBackground(Color.GREEN);
                    button.setText("TURN ON");
                }
            }
        });
    }

    private void drawPanel(String s) {
        Graphics graphics = panel.getGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, panel.getWidth(), panel.getHeight());


        graphics.setColor(Color.GREEN);

        String[] numbers = s.split(",");
        System.out.println(numbers.length);
        try {
            int[] graph = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                graph[i] = Integer.parseInt(numbers[i]);
            }

            for (int i = 0; i < graph.length; i++) {
                graphics.setColor(new Color((int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250)));
                graphics.drawLine(graph[i],graph[i],((int)(Math.random()*200)),((int)(Math.random()*200)));
            }

        } catch (Exception e) {
            graphics.setColor(Color.red);
            graphics.drawString("ONLY NUMBERS PLS", 20, 20);
            return;
        }

        graphics.dispose();

    }

    private void resizeComponent(Component... component) {
        for (Component comp : component) {
            comp.setBounds(comp.getX(), comp.getY(), getContentPane().getWidth() - (comp.getX() * 2), comp.getHeight());
        }
    }
}
