
package Graphic.Exp.sleep;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Sleep extends TimerTask {
    
    //@Override
    public void run() {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        System.out.println(format1.format(d));
        //System.out.println("TimerTask начал свое выполнение в:" + d);
    }
  
    public static void main(String args[]){
        
        
        TimerTask timerTask = new Sleep();
        // стартуем TimerTask в виде демона
        
        Timer timer = new Timer(true);
        // будем запускать каждую секунду (1 * 1000 миллисекунд)
        timer.scheduleAtFixedRate(timerTask, 0, 1*1000);
        System.out.println("TimerTask начал выполнение");
        // вызываем cancel() через какое-то время
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        timer.cancel();
        //System.out.println(new Date(System.currentTimeMillis()));
       
        System.out.println("TimerTask прекращена");
    }
}
