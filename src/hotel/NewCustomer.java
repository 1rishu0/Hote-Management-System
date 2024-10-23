package hotel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class NewCustomer extends JFrame {
    
    JPanel contentPane;
    JLabel l1,lblName,lblId,l2,lblName_1,lblGender,lblCountry,lblReserveRoomNumber,lblCheckInStatus,lblDeposits;
    JComboBox comboBox;
    JTextField t1,t2,t3,t5,t6;
    JRadioButton r1,r2;
    Choice c1;
    JButton btnNewButton,btnExit;
    
    public NewCustomer(){
        
        setBounds(530,200,850,550);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l1=new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);
        
        lblName=new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho",Font.PLAIN,20));
        lblName.setBounds(118,11,260,53);
        contentPane.add(lblName);
        
        lblId=new JLabel("ID :");
        lblId.setBounds(35,76,200,14);
        contentPane.add(lblId);
        
        comboBox=new JComboBox(new String[] {"Passport","Adhaar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,73,150,20);
        contentPane.add(comboBox);
        
        l2=new JLabel("Number :");
        l2.setBounds(35,111,200,14);
        contentPane.add(l2);
        
        t1=new JTextField();
        t1.setBounds(271,111,150,20);
        contentPane.add(t1);
        t1.setColumns(10);
        
        lblName_1=new JLabel("Name :");
        lblName_1.setBounds(35,151,200,14);
        contentPane.add(lblName_1);
        
        t2=new JTextField();
        t2.setBounds(271,151,150,20);
        contentPane.add(t2);
        
        lblGender=new JLabel("Gender :");
        lblGender.setBounds(35,191,200,14);
        contentPane.add(lblGender);
        
        r1=new JRadioButton("Male");
        r1.setBounds(271,191,80,12);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.white);
        contentPane.add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(350,191,100,12);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.white);
        contentPane.add(r2);
        
        lblCountry=new JLabel("Country :");
        lblCountry.setBounds(35,231,200,14);
        contentPane.add(lblCountry);
        
        lblReserveRoomNumber=new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35,274,200,14);
        contentPane.add(lblReserveRoomNumber);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }catch(Exception e){}
        c1.setBounds(271,274,150,20);
        contentPane.add(c1);
        
        lblCheckInStatus=new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35,316,200,14);
        contentPane.add(lblCheckInStatus);
        
        lblDeposits=new JLabel("Deposit :");
        lblDeposits.setBounds(35,359,200,14);
        contentPane.add(lblDeposits);
        
        t3=new JTextField();
        t3.setBounds(271,231,150,20);
        contentPane.add(t3);
        t3.setColumns(10);
        
        t5=new JTextField();
        t5.setBounds(271,316,150,20);
        contentPane.add(t5);
        t5.setColumns(10);
        
        t6=new JTextField();
        t6.setBounds(271,359,150,20);
        contentPane.add(t6);
        t6.setColumns(10);
        
        btnNewButton=new JButton("Add");
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String radio=null;
                
                if(r1.isSelected()) radio="Male";
                else if(r2.isSelected()) radio="Female";
                
                String s6=c1.getSelectedItem();
                
                try{
                    conn c=new conn();
                    
                    String s1=(String)comboBox.getSelectedItem();
                    String s2=t1.getText();
                    String s3=t2.getText();
                    String s4=radio;
                    String s5=t3.getText();
                    String s7=t5.getText();
                    String s8=t6.getText();
                    
                    String q1="insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s7+"','"+s8+"')";
                    String q2="update room set availability = 'Occupied' where room_number ="+s6;
                    
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null,"Data Inserted Successfull");
                    new Reception().setVisible(true);
                    setVisible(false);
                }
                catch(NumberFormatException ee){
                    JOptionPane.showMessageDialog(null,"Please Enter a Valid Number");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }
        });
        btnNewButton.setBounds(100,430,120,30);
        btnNewButton.setBackground(Color.black);
        btnNewButton.setForeground(Color.white);
        contentPane.add(btnNewButton);
        
        btnExit=new JButton("Back");
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260,430,120,30);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main (String args[]){
        
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    NewCustomer frame=new NewCustomer();
                    
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
