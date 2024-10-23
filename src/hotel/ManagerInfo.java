package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class ManagerInfo extends JFrame {
    
    JPanel contentPane;
    JTable table;
    JButton btnLoadData,btnExit;
    JLabel lblNewLabel,lblJob,lblName,lblDepartment,l1,l2,l3,l4;
    
    public ManagerInfo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430,200,1000,600);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        
        table=new JTable();
        table.setBounds(0,34,1000,450);
        contentPane.add(table);
        
        btnLoadData=new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   conn c=new conn();
                   String displaycustomersql="select * from Employee where job='Manager'";
                   ResultSet rs=c.s.executeQuery(displaycustomersql);
                   table.setModel(DbUtils.resultSetToTableModel(rs));
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnLoadData.setBounds(350,500,120,30);
        btnLoadData.setBackground(Color.black);
        btnLoadData.setForeground(Color.white);
        contentPane.add(btnLoadData);
        
        btnExit=new JButton("Back");
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               new Reception().setVisible(true);
               setVisible(false);
           } 
        });
        btnExit.setBounds(510,500,120,30);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        lblNewLabel=new JLabel("Name");
        lblNewLabel.setBounds(41,11,46,14);
        contentPane.add(lblNewLabel);
        
        lblJob=new JLabel("Age");
        lblJob.setBounds(159,11,46,14);
        contentPane.add(lblJob);
        
        lblName=new JLabel("Gender");
        lblName.setBounds(273,11,46,14);
        contentPane.add(lblName);
        
        lblDepartment=new JLabel("Job");
        lblDepartment.setBounds(416,11,86,14);
        contentPane.add(lblDepartment);
        
        l1=new JLabel("Salary");
        l1.setBounds(536,11,86,14);
        contentPane.add(l1);
        
        l2=new JLabel("Phone");
        l2.setBounds(656,11,86,14);
        contentPane.add(l2);
        
        l3=new JLabel("Aadhar");
        l3.setBounds(786,11,86,14);
        contentPane.add(l3);
        
        l4=new JLabel("Gmail");
        l4.setBounds(896,11,86,14);
        contentPane.add(l4);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    ManagerInfo frame=new ManagerInfo();
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
