package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame {
    
    JPanel contentPane;
    JLabel lblSearchForRoom,lblRoomAvailable,lblRoomType,lblRoomAvailable_1,lblPrice_1,l1,lblCleanStatus;
    JCheckBox checkRoom;
    Choice c1;
    JButton btnSearch,btnExit;
    JTable table;
    
    public SearchRoom(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,700,500);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        
        lblSearchForRoom=new JLabel("Search For Room");
        lblSearchForRoom.setBounds(250,11,186,31);
        lblSearchForRoom.setFont(new Font("Tahoma",Font.PLAIN,20));
        contentPane.add(lblSearchForRoom);
        
        lblRoomAvailable=new JLabel("Room Bed Type:");
        lblRoomAvailable.setBounds(50,73,96,14);
        contentPane.add(lblRoomAvailable);
        
        lblRoomType=new JLabel("Room Number");
        lblRoomType.setBounds(23,162,96,14);
        contentPane.add(lblRoomType);
        
        lblRoomAvailable_1=new JLabel("Availability");
        lblRoomAvailable_1.setBounds(175,162,120,14);
        contentPane.add(lblRoomAvailable_1);
        
        lblPrice_1=new JLabel("Price");
        lblPrice_1.setBounds(458,162,46,14);
        contentPane.add(lblPrice_1);
        
        l1=new JLabel("Bed Type");
        l1.setBounds(580,162,96,14);
        contentPane.add(l1);
        
        checkRoom=new JCheckBox("Only Display Available");
        checkRoom.setBounds(400,69,205,23);
        checkRoom.setBackground(Color.white);
        contentPane.add(checkRoom);
        
        c1=new Choice();
        c1.add("Single Bed");
        c1.add("Double Bed");
        c1.setBounds(153,70,120,20);
        contentPane.add(c1);
        
        table=new JTable();
        table.setBounds(0,187,700,200);
        contentPane.add(table);
        
        btnSearch=new JButton("Search");
        btnSearch.setBounds(200,400,120,30);
        btnSearch.setBackground(Color.black);
        btnSearch.setForeground(Color.white);
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String SQL="select * from room where bed_type='"+c1.getSelectedItem()+"'";
                String SQL2="select * from room where availability = 'Available' AND bed_type= '"+c1.getSelectedItem()+"'";
                
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    if(checkRoom.isSelected()){
                        rs=c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        contentPane.add(btnSearch);
        
        btnExit=new JButton("Back");
        btnExit.setBounds(380,400,120,30);
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        btnExit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               new Reception().setVisible(true);
               setVisible(false);
           } 
        });
        contentPane.add(btnExit);
        
        lblCleanStatus=new JLabel("Clean Status");
        lblCleanStatus.setBounds(306,162,96,14);
        contentPane.add(lblCleanStatus);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public static void main (String srgs[]){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    SearchRoom frame=new SearchRoom();
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
