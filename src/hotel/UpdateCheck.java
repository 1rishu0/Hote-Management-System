package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class UpdateCheck extends JFrame {
    
    JPanel contentPane;
    JLabel lblUpdateCheckStatus,l1,lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5;
    JTextField txt_ID,txt_Status,txt_Date,txt_Time,txt_Payment;
    JButton btnUpdate,btnExit,btnAdd;
    Choice c1;
    
    public UpdateCheck(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setBounds(500,200,950,500);
        
        lblUpdateCheckStatus=new JLabel("Check-In Details");
        lblUpdateCheckStatus.setFont(new Font("Tahome",Font.PLAIN,20));
        lblUpdateCheckStatus.setBounds(124,11,222,25);
        contentPane.add(lblUpdateCheckStatus);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        l1=new JLabel(i1);
        l1.setBounds(450,70,476,270);
        contentPane.add(l1);
        
        lblNewLabel=new JLabel("ID:");
        lblNewLabel.setBounds(25,88,46,14);
        contentPane.add(lblNewLabel);
        
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
        c1.setBounds(248,85,140,20);
        contentPane.add(c1);
        
        lblNewLabel_1=new JLabel("Room Number :");
        lblNewLabel_1.setBounds(25,129,107,14);
        contentPane.add(lblNewLabel_1);
        
        txt_ID=new JTextField();
        txt_ID.setBounds(248,126,140,20);
        contentPane.add(txt_ID);
        
        lblNewLabel_2=new JLabel("Name :");
        lblNewLabel_2.setBounds(25,174,97,14);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_3=new JLabel("Checked-in :");
        lblNewLabel_3.setBounds(25,216,107,14);
        contentPane.add(lblNewLabel_3);
        
        lblNewLabel_4=new JLabel("Amount Paid (Rs) : ");
        lblNewLabel_4.setBounds(25,261,107,14);
        contentPane.add(lblNewLabel_4);
        
        lblNewLabel_5=new JLabel("Pending Amount (Rs) : ");
        lblNewLabel_5.setBounds(25,302,150,14);
        contentPane.add(lblNewLabel_5);
        
        txt_Status=new JTextField();
        txt_Status.setBounds(248,171,140,20);
        txt_Status.setColumns(10);
        contentPane.add(txt_Status);
        
        txt_Date=new JTextField();
        txt_Date.setBounds(248,216,140,20);
        txt_Date.setColumns(10);
        contentPane.add(txt_Date);
        
        txt_Time=new JTextField();
        txt_Time.setBounds(248,258,140,20);
        txt_Time.setColumns(10);
        contentPane.add(txt_Time);
        
        txt_Payment=new JTextField();
        txt_Payment.setBounds(248,299,140,20);
        txt_Payment.setColumns(10);
        contentPane.add(txt_Payment);
        
        btnUpdate=new JButton("Update");
        btnUpdate.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   conn c=new conn();
                   
                   String s1=c1.getSelectedItem();
                   String s2=txt_ID.getText();
                   String s3=txt_Status.getText();
                   String s4=txt_Date.getText();
                   String s5=txt_Time.getText();
                   
                   c.s.executeUpdate("update customer set room_number='"+s2+"',name='"+s3+"',status='"+s4+"',deposit='"+s5+"',where number='"+s1+"'");
                   
                   JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                   new Reception().setVisible(true);
                   setVisible(false);
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnUpdate.setBounds(168,379,89,23);
        btnUpdate.setBackground(Color.black);
        btnUpdate.setForeground(Color.white);
        contentPane.add(btnUpdate);
        
        btnExit=new JButton("Back");
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               new Reception().setVisible(true);
               setVisible(false);
           }
        });
        btnExit.setBounds(281,379,89,23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        btnAdd=new JButton("Check");
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String s1=c1.getSelectedItem();
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from customer where number ="+s1);
                    
                    while(rs.next()){
                        txt_ID.setText(rs.getString("room_number"));
                        txt_Status.setText(rs.getString("name"));
                        txt_Date.setText(rs.getString("status"));
                        txt_Time.setText(rs.getString("deposit"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
                
                try{
                    String total="";
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from room where room_number ="+txt_ID.getText());
                    while(rs.next()){
                        total=rs.getString("price");
                    }
                    String paid=txt_Time.getText();
                    int pending=Integer.parseInt(total)-Integer.parseInt(paid);
                    txt_Payment.setText(Integer.toString(pending));
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });
        btnAdd.setBounds(56,379,89,23);
        btnAdd.setBackground(Color.black );
        btnAdd.setForeground(Color.white);
        contentPane.add(btnAdd);
        
        getContentPane().setBackground(Color.white);
            
    }
    
    public static void main(String args[]){
        
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    UpdateCheck frame=new UpdateCheck();
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
