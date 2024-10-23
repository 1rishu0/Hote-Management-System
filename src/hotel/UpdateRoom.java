package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class UpdateRoom extends JFrame {
    
    JPanel contentPane;
    JLabel l1,lblUpdateRoomStatus,lblNewLabel,lblAvailability,lblCleanStatus,lblRoomId;
    Choice c1;
    JTextField txt_Ava,txt_Status,txt_Room;
    JButton b1,btnUpdate,btnExit;
    
    public UpdateRoom(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,1000,450);
        contentPane=new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3=i1.getImage().getScaledInstance(550,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l1=new JLabel(i2);
        l1.setBounds(400,80,600,250);
        add(l1);
        
        lblUpdateRoomStatus=new JLabel("Update Room Status");
        lblUpdateRoomStatus.setBounds(85,11,206,34);
        lblUpdateRoomStatus.setFont(new Font("Tahoma",Font.PLAIN,20));
        contentPane.add(lblUpdateRoomStatus);
        
        lblNewLabel=new JLabel("Guest ID:");
        lblNewLabel.setBounds(27,87,90,14);
        contentPane.add(lblNewLabel);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from  customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        lblAvailability=new JLabel("Availability");
        lblAvailability.setBounds(27,187,90,14);
        contentPane.add(lblAvailability);
        
        lblCleanStatus=new JLabel("Clean Status");
        lblCleanStatus.setBounds(27,240,90,14);
        contentPane.add(lblCleanStatus);
        
        txt_Ava=new JTextField();
        txt_Ava.setBounds(160,184,140,20);
        txt_Ava.setColumns(10);
        contentPane.add(txt_Ava);
        
        txt_Status=new JTextField();
        txt_Status.setBounds(160,237,140,26);
        txt_Status.setColumns(10);
        contentPane.add(txt_Status);
        
        txt_Room=new JTextField();
        txt_Room.setBounds(160,130,140,20);
        txt_Room.setColumns(10);
        contentPane.add(txt_Room);
        
        b1=new JButton("Check");
        b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   String s1=c1.getSelectedItem();
                   conn c=new conn();
                   ResultSet rs=c.s.executeQuery("select * from customer where number="+s1);
                   while(rs.next()){
                       txt_Room.setText(rs.getString("room_number"));
                   }
               }catch(Exception e){
                   e.printStackTrace();
               }
               
               try{
                   conn c=new conn();
                   ResultSet rs2=c.s.executeQuery("select * from room where room_number="+txt_Room.getText());
                   while(rs2.next()){
                       txt_Ava.setText(rs2.getString("availability"));
                       txt_Status.setText(rs2.getString("clean_status"));
                   }
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        b1.setBounds(120,315,89,23);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        contentPane.add(b1);
        
        btnUpdate=new JButton("Update");
        btnUpdate.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               try{
                   conn c=new conn();
                   String str="update room set clean_status='"+txt_Status.getText()+"' where room_number="+txt_Room.getText();
                   c.s.executeUpdate(str);
                   JOptionPane.showMessageDialog(null,"Update Successful");
                   new Reception().setVisible(true);
                   setVisible(false);
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnUpdate.setBounds(60,355,89,23);
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
        btnExit.setBounds(180,355,89,23);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        contentPane.add(btnExit);
        
        lblRoomId=new JLabel("Room Number");
        lblRoomId.setBounds(27,133,100,14);
        contentPane.add(lblRoomId);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    UpdateRoom frame=new UpdateRoom();
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
