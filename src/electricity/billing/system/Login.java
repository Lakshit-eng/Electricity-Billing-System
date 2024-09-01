package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    //declare things globally so that ypu can you those things in backend
    JTextField userText, passwordText;
    Choice loginChoice;
    JButton loginButton,cancelButton,signupButton;

Login(){
    super("Login/SignUp");     //title of the frame can be changed by super  ("Super amust be first statement in java");

    getContentPane().setBackground(Color.white);
    JLabel username = new JLabel("UserName");
    username.setBounds(300,60,100,20);
    add(username);

    //text field
     userText = new JTextField();
    userText.setBounds(400,60,150,20);
    add(userText);

    //password
    JLabel password = new JLabel("Password");
    password.setBounds(300,100,100,20);
    add(password);

    //password field
    passwordText = new JPasswordField();
    passwordText.setBounds(400,100,150,20);
    add(passwordText);

    //login as admin or customer
    JLabel login  = new JLabel("Login In As");
    login.setBounds(300,140,100,20);
    add(login);

    //dropdown

     loginChoice = new Choice();
     loginChoice.add("Admin");
     loginChoice.add("Customer");
     loginChoice.setBounds(400,140,150,20);
     add(loginChoice);

    //buttons
     loginButton= new JButton("Login");
     loginButton.setBounds(330,180,100,20);
     add(loginButton);

     cancelButton = new JButton("Cancel");
     cancelButton.setBounds(460,180,100,20);
     add(cancelButton);
     signupButton = new JButton("Signup");
     signupButton.setBounds(400,215,100,20);
     add(signupButton);

     ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
     Image profileTwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
     ImageIcon fProfileOne = new ImageIcon(profileTwo);
     JLabel profileLabel = new JLabel(fProfileOne);
     add(profileLabel);
     profileLabel.setBounds(5,5,250,250);

    setSize(640,300);   //set frame size
    setLocation(400,200);        //change the location of the frame
    //if you want to make a custom layout so remove the default layout first , the default layout is border layout
    setLayout(null);

    setVisible(true);      //default visibility is false ,make it true to make frame visible

}

    public static void main(String[] args) {
        new Login();
    }
}
