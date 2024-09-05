package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

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
     loginButton.addActionListener(this);
     add(loginButton);

     cancelButton = new JButton("Cancel");
     cancelButton.setBounds(460,180,100,20);
     cancelButton.addActionListener(this);
     add(cancelButton);


     signupButton = new JButton("Signup");
     signupButton.setBounds(400,215,100,20);
     signupButton.addActionListener( this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==loginButton){
      //check authentication
        String susername = userText.getText();
        String spassword = passwordText.getText();
        String suser = loginChoice.getSelectedItem();

        try{
            Database c= new Database();
            String query = "select * from Signup where username ='"+susername+"'and password='"+spassword+"'and usertype ='"+suser+"'";
            ResultSet resultset = c.statement.executeQuery(query);
            if(resultset.next()){
                setVisible(false);
                new main_class();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Login");
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    else if(e.getSource()==cancelButton){
        setVisible(false);
    }

    else if(e.getSource()==signupButton){
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
