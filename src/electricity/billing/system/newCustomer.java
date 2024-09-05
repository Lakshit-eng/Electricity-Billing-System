package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class newCustomer extends JFrame {
    JLabel heading,customerName ,meterNum,address,city, state,email,phone;
    JTextField nameText,meterText,addressText,cityText,stateText,emailText,phoneText;
    JButton next,cancel;
    newCustomer(){
        super("New Customer");
                                                            //using panel
       JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(new Color(252,186,3));
       add(panel);
                                                            //heading of the page
       heading = new JLabel("New Customer");
       heading.setBounds(180,10,200,20);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       panel.add(heading);
                                                           //adding labels and text fields
       customerName =new JLabel("Customer Name:");
       customerName.setBounds(50,80,100,20);
       panel.add(customerName);

       nameText = new JTextField();
       nameText.setBounds(180,80,150,20);
       panel.add(nameText);

                                                           //adding another one

       meterNum =new JLabel("Meter Number:");
       meterNum.setBounds(50,120,100,20);
       panel.add(meterNum);

       meterText = new JTextField("");
       meterText.setBounds(180,120,150,20);
       panel.add(meterText);

                                                        //generate a random meter number in the meterText
       Random ran = new Random();
       long number = ran.nextLong() % 1000000;
       meterText.setText(""+Math.abs(number));


                                                       //adding address

        address =new JLabel("Address:");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JTextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

                                                        //adding city

        city =new JLabel("City:");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        //adding state

        state =new JLabel("Address:");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        //adding email
        email =new JLabel("Email:");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        //adding phone number
        phone =new JLabel("Phone No.:");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        //next button

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        panel.add(next);

        //cancel button

        cancel = new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        panel.add(cancel);

    setLayout(new BorderLayout());
    add(panel,"Center");

      //adding image

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        add(imageLabel,"West");


    setSize(700,500);
    setLocation(400,200);
    setVisible(true);
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
