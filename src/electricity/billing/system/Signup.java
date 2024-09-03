package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Signup extends JFrame {
    Choice loginAsCho;    //declare it globally
    TextField meterText,EmployerText ,UserNameText ,NameText,PasswordText;

    Signup(){

        super("Signup Page");

        JLabel createAS = new JLabel("Create account As");
        createAS.setBounds(30,50,125,20);
        add(createAS);


        loginAsCho = new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,120,20);
        add(loginAsCho);


        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30,100,125,20);
        Employer.setVisible(true);
        add(Employer);

        EmployerText = new TextField();
        EmployerText.setBounds(170,100,125,20);
        EmployerText.setVisible(true);
        add(EmployerText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);
        UserNameText = new TextField();
        UserNameText.setBounds(170,140,125,20);
        add(UserNameText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        NameText = new TextField();
        NameText.setBounds(170,180,125,20);
        add(NameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        PasswordText = new TextField();
        PasswordText.setBounds(170,220,125,20);
        add(PasswordText);

    setSize(600,380);
    setLocation(500,200);
    setLayout(null);
    setVisible(true);


    }

    public static void main(String[] args) {
        new Signup();
    }
}
