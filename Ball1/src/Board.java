import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Ball ball;
    private final int Delay=10;

    public int getW(){
        return getWidth();
    }
    public int getH(){
        return getHeight();
    }
    public Board(){
        initBoard();
    }

    private void initBoard(){

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        ball = new Ball();

        timer = new Timer(10,this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }
    private void  doDrawing(Graphics g){

        Graphics2D g2d =(Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.fill(ball.getEllipse2D());


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    step();

    }
    private void step(){

        ball.moveCircle(); // topu hareket ettirme metodu
        ball.olustur();
        repaint(); // ekrana çizdiriyoruz paintcompanent
    }
    private class TAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) { // tuşa bastığımızda gerçekleşecek eylemleri yapıyoruz
           ball.keyPressed(e);
        }

    @Override
    public void keyReleased(KeyEvent e) { //bastıktan sonraki işlemleri yapıyor
        ball.keyReleased(e);

    }
}

}
