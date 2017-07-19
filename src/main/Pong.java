package main;

/**
 * Created by MaxPlays on 18.07.2017.
 */
public class Pong {

    public static Left l;
    public static Right r;
    public static Ball b;
    public static Thread t;
    public static boolean going = true;

    public static void main(String[] args){
        new Pong();
    }

    public Pong(){
        Frame frame = new Frame(800, 600, "Pong");
        l = new Left(frame);
        frame.addItem(l);
        r = new Right(frame);
        frame.addItem(r);
        b = new Ball(frame);
        frame.addItem(b);
        update();
    }

    public void update(){
        t = new Thread(new Runnable() {

        @Override
        public void run(){
            while(going){
                r.update();
                l.update();
                b.update();
                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        });
        t.run();
    }
}
