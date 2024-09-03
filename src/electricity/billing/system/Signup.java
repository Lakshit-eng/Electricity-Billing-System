package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {
    Choice loginAsCho;    //declare it globally
    TextField meterText,EmployerText ,UserNameText ,NameText,PasswordText;
    JButton create,back;
    Signup(){

        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

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

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if(user.equals("Customer")){
                    Employer.setVisible(false);
                    EmployerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }
                else{

                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                    Employer.setVisible(true);
                    EmployerText.setVisible(true);
                }

            }
        });



        create = new JButton("Create");
        create.setBackground(new Color(35, 87, 236));
        create.setForeground(Color.white);
        create.setBounds(50,280,100,30);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBounds(180,280,100,30);
        back.setBackground(new Color(35,87,236));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Signup.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boy = new JLabel(boyIcon2);
        boy.setBounds(320,30,250,250);
        add(boy);

    setSize(600,380);
    setLocation(500,200);
    setLayout(null);
    setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
           String sloginAs = loginAsCho.getSelectedItem();
           String susername =UserNameText.getText();
           String sname =  NameText.getText();
           String spassword = PasswordText.getText();
           String smeter = meterText.getText();
           try{
               Database c = new Database();
               String query = null;

               query = "insert into Signup value('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+sloginAs+"')";
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Account Created");
               setVisible(false);
               new Login();

           }catch(Exception E){
               E.printStackTrace();
           }
        }
        else if(e.getSource()==back){
           setVisible(false);
           new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
