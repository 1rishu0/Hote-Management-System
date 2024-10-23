package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Dashboard extends JFrame {
    
    JLabel NewLabel, AirlineManagementSystem;
    JMenuBar menuBar;
    JMenu AirlineSystem, AirlineSystemHello;
    JMenuItem FlightDetails, FlightDetailshello1, FlightDetailshello2, FlightDetailshello3;
    
    public Dashboard(){
        
        super("HOTEL MANAGEMENT SYSTEM");
        
        setForeground(Color.cyan);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        NewLabel=new JLabel(i3);
        NewLabel.setBounds(0,0,1950,1000);
        add(NewLabel);
        
        AirlineManagementSystem =new JLabel("THE TAJ GROUP WELCOMES YOU");
        AirlineManagementSystem.setBounds(600,60,1000,85);
        AirlineManagementSystem.setForeground(Color.white);
        AirlineManagementSystem.setFont(new Font("Tahoma",Font.PLAIN,46));
        NewLabel.add(AirlineManagementSystem);
        
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        
        AirlineSystem=new JMenu("HOTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.blue);
        menuBar.add(AirlineSystem);
        
        FlightDetails=new JMenuItem("RECEPTION");
        AirlineSystem.add(FlightDetails);
        
        AirlineSystemHello=new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.red);
        menuBar.add(AirlineSystemHello);
        
        FlightDetailshello1=new JMenuItem("ADD EMPLOYEE");
        AirlineSystemHello.add(FlightDetailshello1);
        
        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    new AddEmployee().setVisible(true);
                    
                }catch(Exception e){}
            }
        });
        
        FlightDetailshello2=new JMenuItem("ADD ROOMS");
        AirlineSystemHello.add(FlightDetailshello2);
        
        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                    
                }catch(Exception e){}
            }
        });
        
        FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                new Reception();
            }
        });
        
        FlightDetailshello3=new JMenuItem("ADD DRIVERS");
        AirlineSystemHello.add(FlightDetailshello3);
        
        FlightDetailshello3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    new AddDrivers().setVisible(true);
                    
                }catch(Exception e){}
            }
        });
        
        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    
    public static void main(String args[]){
        
        new Dashboard().setVisible(true);
    }
}
