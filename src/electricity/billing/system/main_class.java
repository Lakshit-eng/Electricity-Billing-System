package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class main_class extends JFrame {
    main_class(){


       setExtendedState(JFrame.MAXIMIZED_BOTH);

       ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
       Image image = imageicon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
       ImageIcon image2 = new ImageIcon(image);
       JLabel bg_image = new JLabel(image2);
       add(bg_image);

                             //use menu bar in this page

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

                                  //add items in menu bar

        JMenu menu = new JMenu("Menu");

                                 //change font
        menu.setFont(new Font("serif",Font.PLAIN,15));
        menubar.add(menu);

        //add dropdown items in this menu bar

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        //add image in the menu items
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImg = imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImg));
        menu.add(newcustomer);

        //customer details option

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,14));

        //add image in the menu items

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerImg2 = imageIcon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerImg2));
        menu.add(customerDetails);

        //deposit details

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        //add icon image
        ImageIcon deposit = new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image deposit2 = deposit.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(deposit2));
        menu.add(depositDetails);

        //calculate bill
        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        //add icon Image
        ImageIcon calc = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calc2 = calc.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calc2));
        menu.add(calculateBill);


       setLayout(new FlowLayout());
       setVisible(true);
    }
    public static void main(String[] args) {
        new main_class();
    }
}
