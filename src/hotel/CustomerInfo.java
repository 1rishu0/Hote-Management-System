package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.border.*;

public class CustomerInfo extends JFrame{
    
    JPanel contentPane;
    JButton btnExit,btnLoadData;
    JLabel lblId,l1,lblNewLabel,lblGender,lblCountry,lblRoom,lblStatus,lblNewLabel_1;
    JTable table;
    
    public CustomerInfo(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,900,600);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        
        btnExit=new JButton("Back");
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){ 
               new Reception().setVisible(true);
               setVisible(false);
           } 
        });
        btnExit.setBounds(450,510,120,30);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        btnLoadData=new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){ 
               try{
                   conn c=new conn();
                   String displaycustomersql="select * from customer";
                   ResultSet rs=c.s.executeQuery(displaycustomersql);
                   table.setModel(DbUtils.resultSetToTableModel(rs));
               }catch(Exception e){
                   e.printStackTrace();
               }
           }
        });
        btnLoadData.setBounds(300,510,120,30);
        btnLoadData.setBackground(Color.black);
        btnLoadData.setForeground(Color.white);
        contentPane.add(btnLoadData);
        
        lblId=new JLabel("ID");
        lblId.setBounds(31,11,46,14);
        contentPane.add(lblId);
        
        l1=new JLabel("Number");
        l1.setBounds(150,11,46,14);
        contentPane.add(l1);
        
        lblNewLabel=new JLabel("Name");
        lblNewLabel.setBounds(270,11,65,14);
        contentPane.add(lblNewLabel);
        
        lblGender=new JLabel("Gender");
        lblGender.setBounds(360,11,46,14);
        contentPane.add(lblGender);
        
        table=new JTable();
        table.setBounds(0,40,900,450);
        contentPane.add(table);
        
        lblCountry=new JLabel("Country");
        lblCountry.setBounds(480,11,46,14);
        contentPane.add(lblCountry);
        
        lblRoom =new JLabel("Room");
        lblRoom.setBounds(600,11,46,14);
        contentPane.add(lblRoom);
        
        lblStatus=new JLabel("Check-in Status");
        lblStatus.setBounds(680,11,100,14);
        contentPane.add(lblStatus);
        
        lblNewLabel_1=new JLabel("Deposit");
        lblNewLabel_1.setBounds(800,11,100,14);
        contentPane.add(lblNewLabel_1);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    CustomerInfo frame=new CustomerInfo();
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
