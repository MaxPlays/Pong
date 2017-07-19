package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MaxPlays on 19.07.2017.
 */
public class Ball extends JPanel{

    JFrame frame;
    int x, y, velocityX, velocityY;
    int i = 0;

    public Ball(JFrame f) {
        this.frame = f;
        spawn(Pong.l.getX(), Pong.l.getY());
    }

    public void update() {

        if(y + velocityY <= 0 | y + velocityY + 40 >= frame.getHeight()){
            bounce(BounceSide.UPDOWN);
        }

        if(hits() == Side.LEFT){
            Pong.r.setScore(Pong.r.getScore() + 1);
            spawn(Pong.l.getX(), Pong.l.getY());
            setBackground(Color.black);
            AudioManager.playScoreSound();
            i = 0;
            return;
        }else if(hits() == Side.RIGHT){
            Pong.l.setScore(Pong.l.getScore() + 1);
            spawn(Pong.r.getX(), Pong.r.getY());
            setBackground(Color.black);
            AudioManager.playScoreSound();
            i = 0;
            return;
        }else if(hits() == Side.LEFT_OK){
            bounce(BounceSide.LEFTRIGHT);
            AudioManager.playHitSound();
        }else if(hits() == Side.RIGHT_OK){
            bounce(BounceSide.LEFTRIGHT);
            AudioManager.playHitSound();
        }

        x += velocityX;
        y += velocityY;

        setBounds(x, y, 10, 10);
        setBackground(Color.white);
    }

    public void spawn(int targetX, int targetY){
        x = frame.getWidth()/2 - 5;
        y = frame.getHeight()/2 - 5;

        velocityX = targetX - x;
        velocityY = targetY - y;

        double vX = velocityX;
        double vY = velocityY;

        double root = Math.sqrt(Math.pow(Math.abs(vX), 2) + Math.pow(Math.abs(vY), 2));
        vX /= root;
        vY /= root;

        velocityX = (int)(vX * 8);
        velocityY = (int)(vY * 8);

    }

    public void bounce(BounceSide side){
        if(side == BounceSide.LEFTRIGHT){
            velocityX *= -1;
            i++;
        }else if(side == BounceSide.UPDOWN){
            velocityY *= -1;
            i++;
        }
        if(i >= 15){
            velocityX *= 1.3;
            velocityY *= 1.3;
            i = 0;
        }
    }

    public Side hits(){
        if(x >= Pong.l.x && x <= (Pong.l.x + Pong.l.width) && ((y + 5) >= Pong.l.getY()) && ((y + 5) <= (Pong.l.getY() + Pong.l.heigth))){
            return Side.LEFT_OK;
        }else if(x >= (Pong.r.x - 5) && x <= (Pong.r.x + Pong.r.width) && ((y + 5) >= Pong.r.getY()) && ((y + 5) <= (Pong.r.getY() + Pong.r.heigth))) {
            return Side.RIGHT_OK;
        }else if(x < 5){
            return Side.LEFT;
        }else if(x > frame.getWidth() - 5){
            return Side.RIGHT;
        }else{
            return Side.NONE;
        }
    }

    enum Side {
        LEFT, RIGHT, NONE, LEFT_OK, RIGHT_OK;
    }
    enum BounceSide{
        UPDOWN, LEFTRIGHT;
    }


}
