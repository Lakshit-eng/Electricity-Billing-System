package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculate_bill extends JFrame implements ActionListener {

    JLabel nameText,addressText;
    TextField unitText;
    Choice meterNumCho,monthCho;
    JButton submit,cancel;

    calculate_bill(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meter_no = new JLabel("Meter Number:");
        meter_no.setBounds(50,80,100,20);
        panel.add(meter_no);

        meterNumCho = new Choice();
        try{
            Database c= new Database();
            ResultSet resultset = c.statement.executeQuery("select * from new_customer");
            while(resultset.next()){
                meterNumCho.add(resultset.getString("meter_no"));
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        meterNumCho.setBounds(180,80,100,20);
        panel.add(meterNumCho);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180,120,100,20);
        panel.add(nameText);

        JLabel address= new JLabel("Address:");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        try{
            Database c= new Database();
            ResultSet resultset = c.statement.executeQuery("select * from new_customer where meter_no ='"+meterNumCho.getSelectedItem()+"'");
            while(resultset.next()){
                nameText.setText(resultset.getString("name"));
                addressText.setText(resultset.getString("address"));
            }

        }catch(Exception E){
            E.printStackTrace();
        }

        meterNumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Database c= new Database();
                    ResultSet resultset = c.statement.executeQuery("select * from new_customer where meter_no ='"+meterNumCho.getSelectedItem()+"'");
                    while(resultset.next()){
                        nameText.setText(resultset.getString("name"));
                        addressText.setText(resultset.getString("address"));
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel unitconsumed = new JLabel("Units Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitText = new TextField();
        unitText.setBounds(180,200,150,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho= new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(180,240,150,20);
        panel.add(monthCho);

        submit=new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image i2 = i1.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i2);
        JLabel img2 = new JLabel(img);
        add(img2,"East");


        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==submit){
          String smeterNo = meterNumCho.getSelectedItem();
          String sunit = unitText.getText();
          String smonth = monthCho.getSelectedItem();

          int totalBill = 0;
          int units=Integer.parseInt(sunit);
          String query_text = "Select * from tax";
          try{
              Database c = new Database();
              ResultSet resultSet = c.statement.executeQuery(query_text);
              while (resultSet.next()){
                  totalBill  = totalBill + units *Integer.parseInt(resultSet.getString("cost_per_unit"));
                  totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                  totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                  totalBill += Integer.parseInt(resultSet.getString("swachh_bharat"));
                  totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));
              }
          }catch(Exception E){
              E.printStackTrace();
          }

          String query_total_bill ="insert into bill values('"+smeterNo+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not paid')";
          try{
              Database c= new Database();
              c.statement.executeUpdate(query_total_bill);

              JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
              setVisible(false);
          }catch(Exception E){
              E.printStackTrace();
          }
     }else{
         setVisible(false);
     }
    }

    public static void main(String[] args) {
        new calculate_bill();
    }

}
