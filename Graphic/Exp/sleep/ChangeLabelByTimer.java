
package Graphic.Exp.sleep;

import java.util.Timer;
import java.util.TimerTask;

public class ChangeLabelByTimer {
    Timer timer;
 
  public ChangeLabelByTimer(int seconds) {
    timer = new Timer();
    timer.schedule(new RemindTask(), seconds * 1000);
  }
 
  class RemindTask extends TimerTask {
    public void run() {
      jLabel1.setText("текст");
      System.exit(0); 
    }
  }
 
  public static void main(String args[]) {
    System.out.println("Сейчас изменится label.");
    new ChangeLabelByTimer(5);  // задал обновить через 5 секунд, если какой то период нужен то задай в цикле
    System.out.println("label изменился.");
  }
}

