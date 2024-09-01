package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
         ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Splash.jpg"));  //import image icon
        Image image_one = imageicon.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
          ImageIcon imageicon2 = new ImageIcon(image_one);
         JLabel imageLabel = new JLabel(imageicon2);    // we cant add image directly to the frame so,create a J Label
        add(imageLabel);    //   add image to the frame




        setSize(500,500);   //set frame size
        setLocation(500,200);        //change the location of the frame
        setVisible(true);      //default visibility is false ,make it true to make frame visible

        //the splash class wil come and go within tree sec and redirect us to a new page

        try{
             //use sleep function
            Thread.sleep(3000);
            setVisible(false);   //to close the frame

            //new page opening
            new Login();
        }catch (Exception e){             //catch
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
