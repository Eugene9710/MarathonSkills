
package Graphic.Exp.sleep;

import java.applet.Applet;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chasi extends Applet implements Runnable {
  Graphics g;
  Thread motor;
  Date date;
  Dimension d;
  
  /*
    В методе init происходит первичная инициализация аплета ( устанавливается
    необходимый шрифт для изображения времени, запоминаются размеры
    окна , устанавливается цвет фона.
  */
  public void init () {
   // g = getGraphics();
   // date = new Date();
    Font fn = new Font("Gost Type B",Font.PLAIN,24);
    setFont(fn);
    d = this.size();
  //  setBackground(Color.black);
  }
  
  /*
    Создается объект класса Thread и запускается процесс , связанный с
    объектом motor
  */
  public void start() {
    if(motor == null)
      motor = new Thread(this);
      motor.start();
  }
 
  /*
    Выполнение программы приостанавливается
  */
  public void stop () {
    motor.stop();
    motor = null;
  }
 
  /*
    При запуске процесса , ассоциированного с объектом motor 
    устанавливается минимальный приоритет для процесса
    затем, программа входит в бесконечный цикл
    где считывается текущее время , окно перерисовывается и
    процесс вновь засыпает на 1 секунду
    После чего все повторяется
  */
  public void run() {
    motor.setPriority(Thread.MIN_PRIORITY);
    while( motor != null) 
    {
      date = new Date();
      repaint();
      try {
	Thread.sleep(1000);
      } catch (Exception e) {};
     // System.out.println(date);
    }
  }
 
  /*
    В методе paint происходит перерисовка окна апплета
    Из объекта date вынимаются колличество часов, минут и секунд
    и помещаются в строку ss , разделенные символом ':'
    Затем строка центрируется по высоте и ширине окна и 
    выводится на экран
  */
  @Override
  public void paint(Graphics g) {
    g.setColor(Color.green);
    FontMetrics fm = g.getFontMetrics();
    int hi = date.getHours();
    int mi = date.getMinutes();
    int si = date.getSeconds();
    String s,m,h;
    if(si<10)
      s="0"+si;
    else
      s=""+si;
    if(mi<10)
      m="0"+mi;
    else
      m=""+mi;
    if(hi<10)
      h="0"+hi;
    else
      h=""+hi;
    String ss = h+":"+m+":"+s;
    //String ss = "111";
    int x = (d.width - fm.stringWidth(ss))/2;
    int y = fm.getAscent() + ( d.height - (fm.getAscent() + fm.getDescent()))/2;
    g.drawString(ss,x,y);
    //SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
    }          
}
    

