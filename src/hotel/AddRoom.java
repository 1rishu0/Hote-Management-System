package hotel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddRoom extends JFrame implements ActionListener{
    
    JPanel contentPane;
    JLabel l15,l10,l1,l2,l3,l4,l5;
    JTextField t4,t2;
    JComboBox comboBox,comboBox_2,comboBox_3;
    JButton b1,b2;
    
    AddRoom(){
        setBounds(450,200,1000,450);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        l15=new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);
        
        l10=new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma",Font.BOLD,18));
        l10.setBounds(194,10,120,22);
        contentPane.add(l10);
        
        l1=new JLabel("Room Number");
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(new Color(25,25,112));
        l1.setBounds(64,70,102,22);
        contentPane.add(l1);
        
        t4=new JTextField();
        t4.setBounds(174,70,156,20);
        contentPane.add(t4);
        
        l2=new JLabel("Availability");
        l2.setForeground(new Color(25,25,112));
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setBounds(64,110,102,22);
        contentPane.add(l2);
        
        comboBox=new JComboBox(new String[]{"Available","Occupied"});
        comboBox.setBounds(176,110,154,20);
        contentPane.add(comboBox);
        
        l3=new JLabel("Cleaning Status");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(64,150,102,22);
        l3.setForeground(new Color(25,25,112));
        contentPane.add(l3);
        
        comboBox_2=new JComboBox(new String[] {"Cleaned","Dirty"});
        comboBox_2.setBounds(176,150,154,20);
        contentPane.add(comboBox_2);
        
        l4=new JLabel("Price");
        l4.setForeground(new Color(25,25,112));
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(64,190,102,22);
        contentPane.add(l4);
        
        t2=new JTextField();
        t2.setBounds(174,190,156,20);
        contentPane.add(t2);
        
        l5=new JLabel("Bed Type");
        l5.setBounds(64,230,102,22);
        l5.setForeground(new Color(25,25,112));
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        contentPane.add(l5);
        
        comboBox_3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        comboBox_3.setBounds(176,230,154,20);
        contentPane.add(comboBox_3);
        
        b1=new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        contentPane.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        contentPane.add(b2);
        
        contentPane.setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==b1){
                try{
                    conn c=new conn();
                    String room=t4.getText();
                    String available=(String)comboBox.getSelectedItem();
                    String status=(String)comboBox_2.getSelectedItem();
                    String price=t2.getText();
                    String type=(String)comboBox_3.getSelectedItem();
                    String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Room Successfully Added");
                    this.setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()==b2){
                this.setVisible(false);
            }
        }catch(Exception ee){}
    }
    
    public static void main(String args[]){
        new AddRoom().setVisible(true);
    }
}
