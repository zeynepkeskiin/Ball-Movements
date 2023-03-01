import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private int w = 900;
    private int h = 700;

    public Main(){
        initUI();

    }
    private void initUI(){
        add(new Board());

        setTitle("Klavye top hareketi");
        setSize(w,h);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[]args){

        EventQueue.invokeLater(() ->{
            Main  ex = new Main();
            ex.setVisible(true);
        });
    }


}