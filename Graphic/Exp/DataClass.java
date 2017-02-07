package Graphic.Exp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataClass {
    public static void main(String[] args) throws ParseException {
          
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                     
            Date date1 = new Date();
                       
            Date date2 = dateFormat.parse("17.05.2018");
 
            long milliseconds = date2.getTime() - date1.getTime();

            int seconds = (int) (milliseconds / (1000));

            int minutes = (int) (milliseconds / (60 * 1000));

            int hours = (int) (milliseconds / (60 * 60 * 1000));

            int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
     
            int years = (int) (days / 365);

            int days1 = (int) (days - years * 365);
      
            int hours1 = (int) (hours - (years * 365 + days1)*24);
   
            int minutes1 = (int) (minutes - ((years * 365 + days1) * 24 + hours1) * 60 );

            int seconds1 = (int) (seconds - (((years * 365 + days1) * 24 + hours1) * 60 + minutes1) * 60);
         System.out.println(seconds1);
        } 
}