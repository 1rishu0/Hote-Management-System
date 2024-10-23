package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class PickUp extends JFrame{
    
    JPanel contentPane;
    JLabel lblPickUpServices,lblTypeofCar,lblInfo,lblNewLabel,lblGender,lblTypeofDriver,lblDateOfThe,lblAirport,lblAvailable;
    Choice c1;
    JButton btnRegister,btnExit;
    JTable table;
    
    public PickUp(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,800,600);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        
        lblPickUpServices=new JLabel("Pick Up Service");
        lblPickUpServices.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblPickUpServices.setBounds(90,11,158,25);
        contentPane.add(lblPickUpServices);
        
        lblTypeofCar=new JLabel("Type of Car");
        lblTypeofCar.setBounds(32,97,89,14);
        contentPane.add(lblTypeofCar);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(123,94,150,25);
        contentPane.add(c1);
        
        lblInfo=new JLabel("Name");
        lblInfo.setBounds(24,208,46,14);
        contentPane.add(lblInfo);
        
        table=new JTable();
        table.setBounds(0,233,800,250);
        contentPane.add(table);
        
        btnRegister=new JButton("Display");
        btnRegister.setBounds(200,500,120,30);
        btnRegister.setBackground(Color.black);
        btnRegister.setForeground(Color.white);
        btnRegister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String SQL="select * from driver where brand ='"+c1.getSelectedItem()+"'";
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });
        contentPane.add(btnRegister);
        
        btnExit=new JButton("Back");
        btnExit.setBounds(420,500,120,30);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               new Reception().setVisible(true);
               setVisible(false);
           } 
        });
        contentPane.add(btnExit);
        
        lblNewLabel=new JLabel("Age");
        lblNewLabel.setBounds(165,208,46,14);
        contentPane.add(lblNewLabel);
        
        lblGender=new JLabel("Gender");
        lblGender.setBounds(264,208,46,14);
        contentPane.add(lblGender);
        
        lblTypeofDriver=new JLabel("Company");
        lblTypeofDriver.setBounds(366,208,80,14);
        contentPane.add(lblTypeofDriver);
        
        lblDateOfThe=new JLabel("Brand");
        lblDateOfThe.setBounds(486,208,105,14);
        contentPane.add(lblDateOfThe);
        
        lblAirport=new JLabel("Available");
        lblAirport.setBounds(600,208,86,14);
        contentPane.add(lblAirport);
        
        lblAvailable=new JLabel("Location");
        lblAvailable.setBounds(700,208,73,14);
        contentPane.add(lblAvailable);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
           public void run(){
               try{
                   PickUp frame=new PickUp();
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
