package hotel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class CheckOut extends JFrame{
    
    JPanel contentPane;
    JLabel l1,lblCheckOut,lblName,lblRoomNumber;
    Choice c1;
    JButton l2,btnCheckOut,btnExit;
    JTextField t1;
    
    CheckOut(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setBounds(530,200,800,294);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3=i1.getImage().getScaledInstance(400,225,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l1=new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);
        
        lblCheckOut=new JLabel("Check Out");
        lblCheckOut.setBounds(70,11,140,35);
        lblCheckOut.setFont(new Font("Tahome",Font.PLAIN,20));
        contentPane.add(lblCheckOut);
        
        lblName=new JLabel("Number :");
        lblName.setBounds(20,85,80,14);
        contentPane.add(lblName);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(130,82,150,20);
        contentPane.add(c1);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        l2=new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);
        l2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               System.out.println("Hi");
               try{
                   conn c=new conn();
                   String number=c1.getSelectedItem();
                   ResultSet rs=c.s.executeQuery("select * from customer where number = "+number);
                   
                   if(rs.next()){
                       System.out.println("Clicked");
                       t1.setText(rs.getString("room_number"));
                   }
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        
        lblRoomNumber=new JLabel("Room Number :");
        lblRoomNumber.setBounds(20,132,86,20);
        contentPane.add(lblRoomNumber);
        
        t1=new JTextField();
        t1.setBounds(130,132,150,20);
        contentPane.add(t1);
        
        btnCheckOut=new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String id=c1.getSelectedItem();
                String s1=t1.getText();
                String deleteSQL="delete from customer where number ="+id;
                String q2="update room set availability='Available' where room_number="+s1;
                
                try{
                    conn c=new conn();
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Check Out Successful");
                    setVisible(false);
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        });
        btnCheckOut.setBounds(50,200,100,25);
        btnCheckOut.setBackground(Color.black);
        btnCheckOut.setForeground(Color.white);
        contentPane.add(btnCheckOut);
        
        btnExit=new JButton("Back");
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   new Reception().setVisible(true);
                   setVisible(false);
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnExit.setBounds(160,200,100,25);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    CheckOut frame=new CheckOut();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void close(){
        this.dispose();
    }
    
}
