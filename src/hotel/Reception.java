package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Reception extends JFrame {
    
    JPanel contentPane;
    JLabel l1;
    JButton btnNewCustomerForm , btnNewButton, btnNewButton_2, btnNewButton_3, btnManagerInfo, btnNewButton_4, btnNewButton_5, btnNewButton_6, btnPickUpSerice, btnSearchRoom, btnNewButton_7;
    
    public Reception(){
        
        setBounds(530,200,850,570);
        
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l1=new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);
        
        btnNewCustomerForm=new JButton("New Customer Form");
        btnNewCustomerForm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    NewCustomer custom=new NewCustomer();
                    custom.setVisible(true);
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewCustomerForm.setBounds(10,30,200,30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.white);
        contentPane.add(btnNewCustomerForm);
        
        btnNewButton=new JButton("Room");
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    Room room=new Room();
                    room.setVisible(true);
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(10,70,200,30);
        btnNewButton.setBackground(Color.black);
        btnNewButton.setForeground(Color.white);
        contentPane.add(btnNewButton);
        
        btnNewButton_2=new JButton("All Employee Info");
        btnNewButton_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    Employee em=new Employee();
                    em.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(10,150,200,30);
        btnNewButton_2.setBackground(Color.black);
        btnNewButton_2.setForeground(Color.white);
        contentPane.add(btnNewButton_2);
        
        btnNewButton_3=new JButton("Customer Info");
        btnNewButton_3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    CustomerInfo customer=new CustomerInfo();
                    customer.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(10,190,200,30);
        btnNewButton_3.setBackground(Color.black);
        btnNewButton_3.setForeground(Color.white);
        contentPane.add(btnNewButton_3);
        
        btnManagerInfo=new JButton("Manager Info");
        btnManagerInfo.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               
               try{
                   ManagerInfo mana=new ManagerInfo();
                   mana.setVisible(true);
                   setVisible(false);
               }catch(Exception e){
                   e.printStackTrace();
               }
           } 
        });
        btnManagerInfo.setBounds(10,230,200,30);
        btnManagerInfo.setBackground(Color.black);
        btnManagerInfo.setForeground(Color.white);
        contentPane.add(btnManagerInfo);
        
        btnNewButton_4=new JButton("Check Out");
        btnNewButton_4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    CheckOut check=new CheckOut();
                    check.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(10,270,200,30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.white);
        contentPane.add(btnNewButton_4);
        
        btnNewButton_5=new JButton("Updata Check Status");
        btnNewButton_5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    UpdateCheck update=new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds(10,310,200,30);
        btnNewButton_5.setBackground(Color.black);
        btnNewButton_5.setForeground(Color.white);
        contentPane.add(btnNewButton_5);
        
        btnNewButton_6=new JButton("Update Room Status");
        btnNewButton_6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    UpdateRoom room=new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_6.setBounds(10,350,200,30);
        btnNewButton_6.setBackground(Color.black);
        btnNewButton_6.setForeground(Color.white);
        contentPane.add(btnNewButton_6);
        
        btnPickUpSerice=new JButton("Pick up Service");
        btnPickUpSerice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    PickUp pick=new PickUp();
                    pick.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnPickUpSerice.setBounds(10,390,200,30);
        btnPickUpSerice.setBackground(Color.black);
        btnPickUpSerice.setForeground(Color.white);
        contentPane.add(btnPickUpSerice);
        
        btnSearchRoom=new JButton("Search Room");
        btnSearchRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    SearchRoom search=new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnSearchRoom.setBounds(10,430,200,30);
        btnSearchRoom.setBackground(Color.black);
        btnSearchRoom.setForeground(Color.white);
        contentPane.add(btnSearchRoom);
        
        btnNewButton_7=new JButton("Log Out");
        btnNewButton_7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    new Login().setVisible(true);
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_7.setBounds(10,470,200,30);
        btnNewButton_7.setBackground(Color.black);
        btnNewButton_7.setForeground(Color.white);
        contentPane.add(btnNewButton_7);
        
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        
        new Reception();
    }
}
