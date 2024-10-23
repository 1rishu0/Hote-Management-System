package hotel;

import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Room extends JFrame {
    
    JLabel l1,lblAvailability,lblCleanStatus,lblNewLabel,lblNewLabel_1,lblId;
    JTable table;
    JButton btnLoadData,btnNewButton;
    JPanel contentPane;
    
    public Room() throws Exception{
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,200,1100,600);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l1=new JLabel(i2);
        l1.setBounds(500,0,600,600);
        add(l1);
        
        table=new JTable();
        table.setBounds(0,40,500,400);
        contentPane.add(table);
        
        btnLoadData=new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   conn c=new conn();
                   String displayCustomersql="select * from Room";
                   ResultSet rs=c.s.executeQuery(displayCustomersql);
                   table.setModel(DbUtils.resultSetToTableModel(rs));
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnLoadData.setBounds(100,470,120,30);
        btnLoadData.setBackground(Color.black);
        btnLoadData.setForeground(Color.white);
        contentPane.add(btnLoadData);
        
        btnNewButton=new JButton("Back");
        btnNewButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               new Reception().setVisible(true);
               setVisible(false);
           } 
        });
        btnNewButton.setBounds(290,470,120,30);
        btnNewButton.setBackground(Color.black);
        btnNewButton.setForeground(Color.white);
        contentPane.add(btnNewButton);
        
        lblAvailability=new JLabel("Availability");
        lblAvailability.setBounds(119,15,69,14);
        contentPane.add(lblAvailability);
        
        lblCleanStatus=new JLabel("Clean Status");
        lblCleanStatus.setBounds(216,15,76,14);
        contentPane.add(lblCleanStatus);
        
        lblNewLabel=new JLabel("Price");
        lblNewLabel.setBounds(330,15,46,14);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1=new JLabel("Bed Type");
        lblNewLabel_1.setBounds(417,15,46,14);
        contentPane.add(lblNewLabel_1);
        
        lblId=new JLabel("Room Number");
        lblId.setBounds(12,15,90,14);
        contentPane.add(lblId);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    Room frame=new Room();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
}
