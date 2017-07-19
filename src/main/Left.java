package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by MaxPlays on 18.07.2017.
 */
public class Left extends JPanel implements KeyListener{

    int x, y, width, heigth;
    JFrame frame;
    int velocity = 0;
    int score = 0;

    public Left(JFrame f){
        frame = f;
        width = 10;
        heigth = 100;
        x = 20;
        y = (f.getHeight()/2) - heigth;
        f.addKeyListener(this);
    }

    public void update() {
        if((getY() + velocity > 0) & (getY() + heigth + velocity + 30 < frame.getHeight()))
            setY(getY() + velocity);
        setBounds(x, y, width, heigth);
        setBackground(Color.white);
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            velocity = -4;
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            velocity = 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W && velocity < 0)
            velocity = 0;
        if(e.getKeyCode() == KeyEvent.VK_S && velocity > 0)
            velocity = 0;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        Frame.lScore.setText(String.valueOf(score));
        if(score >= 10){
            Pong.going = false;
            Frame.lScore.setText("");
            Frame.spacer.setText("Left side wins");
            Frame.rScore.setText("");
        }
    }
}
