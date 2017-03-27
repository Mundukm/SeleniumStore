package pack;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.awt.event.ActionEvent;

/**
 * Created by Kolja on 25.03.2017.
 */
public class Main {

    public static WebConnect connectKlubok;
    public static WebConnect connectKlumba;
    public static EncoderKlybok encoderKlybok;
    public static EncoderKlumba encoderKlumba;


    public static void main(String[] args) {

        encoderKlybok = new EncoderKlybok();
        encoderKlumba = new EncoderKlumba();



            connectKlubok = new WebConnect();
            connectKlumba = new WebConnect();
            connectKlubok.getDriver().manage().window().setSize(new Dimension(800,900));
            connectKlumba.getDriver().manage().window().setSize(new Dimension(800,900));
            connectKlubok.getDriver().manage().window().setPosition(new Point(0,0));
            connectKlumba.getDriver().manage().window().setPosition(new Point(800,0));


        MyWindow window = new MyWindow();








    }
}
