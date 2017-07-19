package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MaxPlays on 18.07.2017.
 */
public class Frame extends JFrame{

    JPanel p;
    static JLabel rScore, lScore, spacer;

    public Frame(int width, int heigth, String title) {

        setTitle(title);
        setSize(new Dimension(width, heigth));
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBounds(0, 0, width, heigth);
        p.setBackground(Color.black);
        add(p);

        lScore = new JLabel("0");
        lScore.setFont(new Font("Monospaced", Font.PLAIN, 50));
        lScore.setForeground(Color.white);
        p.add(lScore);

        spacer = new JLabel(" | ");
        spacer.setFont(new Font("Monospaced", Font.PLAIN, 50));
        spacer.setForeground(Color.white);
        p.add(spacer);

        rScore = new JLabel("0");
        rScore.setFont(new Font("Monospaced", Font.PLAIN, 50));
        rScore.setForeground(Color.white);
        p.add(rScore);

    }

    public void addItem(Component c){
        p.add(c);
    }


}
