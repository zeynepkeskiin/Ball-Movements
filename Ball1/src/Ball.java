import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

    private Ellipse2D ellipse2D;

    boolean yukari_cik , sola_git;
    private int dx =0; //sağ ve sol tuşumuza bastığımızda hızlanmamızı saülayacak değerler
    private int dy=0;
    private int dr; // topumuzun genişliğinin artış miktarını belirleyecek
    private int pos_x=360;
    private int pos_y =260; //topun mevcut konumları
    private int radius =90; //topun ilk genişliği

    private  int speedX=1;
    private  int speedY=1;

    public void olustur() {

        ellipse2D = new Ellipse2D.Double(pos_x,pos_y,radius,radius);

        }
        public void  moveCircle(){

        radius +=dr; // asağı yukarı tuşumuza basıldıysa artış değeri ekliyo

        if(pos_x>885 - radius){
            sola_git = true;
        }
            if(pos_x < 0 ){
                sola_git = false;
            }
            if (sola_git){
                pos_x -= speedX;
            }
            else {
                pos_x += speedX;
            }
            if(pos_y>665 - radius){ //y ekseninde 665 alanlık yerde hareket eder azaltırsak alanı kısıtlı olur
                yukari_cik = true;
            }
            if (pos_y<0){
                yukari_cik=false;
            }

            if (yukari_cik){
                pos_y -= speedY;
            }
            else {
                pos_y += speedY;
            }

        }
        public Ellipse2D getEllipse2D(){
        return ellipse2D;
        }
        public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        if (key== KeyEvent.VK_LEFT){ //sol tuşa basılırsa dx ve dy değerlerini azaltırız
            if (speedX >0){
                if (dx==0){
                    dx --;
                    dy--;
                }
            }
            speedX +=dx; //artış veya azalış değerine göre speede ekleriz
            speedY +=dy;
        }
        if (key==KeyEvent.VK_RIGHT){ // sağa basılınca hızlandırıyoruz
            if (speedX<30){
                if(dx==0){
                    dx ++;
                    dy ++;
                }
            }
            speedX+=dx;
            speedY+=dy;
        }
        if (key == KeyEvent.VK_UP){//yukarı basılırsa dr artar
            dr =1;
        }
        if (key == KeyEvent.VK_DOWN){//aşağı basılırsa dr azalır
            dr =-1;
        }
        }
    public void keyReleased(KeyEvent e) { // ile üstüste artamsını engelliyoruz
        int key = e.getKeyCode();


        if (key == KeyEvent.VK_LEFT) {
            dy = 0;
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dy = 0;
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dr = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dr = 0;
        }
    }
}