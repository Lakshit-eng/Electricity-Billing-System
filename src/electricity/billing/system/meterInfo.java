package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocCho,meterTypCho,phaseCodeCho,billTypeCho;
    JButton submit;
    String meternumber;

    meterInfo(String meternumber){
        super("Meter Information");
        this.meternumber= meternumber;


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        //heading

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        //adding labels

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        //adding meter number
        JLabel meterNumberText = new JLabel(meternumber);
        meterNumberText.setBounds(180,80,150,20);
        panel.add(meterNumberText);

        //meter location

        JLabel meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        //meter location choice

        meterLocCho = new Choice();
        meterLocCho.setBounds(180,120,150,20);
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        panel.add(meterLocCho);

        //meter type

        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        //meter type dropdown

        meterTypCho = new Choice();
        meterTypCho.add("Electric Meter");
        meterTypCho.add("Solar Meter");
        meterTypCho.add("Smart Meter");
        meterTypCho.setBounds(180,160,150,20);
        panel.add(meterTypCho);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);


        phaseCodeCho= new Choice();

        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");

        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho= new Choice();

        billTypeCho.add("Individual");
        billTypeCho.add("Commercial");


        billTypeCho.setBounds(180,240,150,20);
        panel.add(billTypeCho);

        JLabel day = new JLabel("30 Days Billing Time...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("BY default bill is calculated for 30 days only.");
        note1.setBounds(50,340,250,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image I2 = bg.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel bgImg = new JLabel(I3);
        add(bgImg,"East");



        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeterNum = meternumber;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterType = meterTypCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String sbillType = billTypeCho.getSelectedItem();
            String sday = "30";


            String query_meter_info = "insert into meter_info values('"+smeterNum+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sday+"')";
            try{

                Database c = new Database();
                c.statement.executeUpdate(query_meter_info);
                JOptionPane.showMessageDialog(null,"Meter information submitted successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
