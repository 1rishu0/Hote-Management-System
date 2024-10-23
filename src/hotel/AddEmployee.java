package hotel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AddEmployee extends JFrame {
    
    JLabel Passportno, Pnrno, Gender, Address, Nationality, Name, Phno, email, AddPassengers, image;
    JTextField textField, textField_1, textField_3, textField_4, textField_5, textField_6;
    JButton Next;
    JRadioButton NewRadioButton, Female;
    JComboBox c1;
    
    AddEmployee(){
        getContentPane().setForeground(Color.blue);
        getContentPane().setBackground(Color.white);
        setTitle("ADD EMPLOYEE DETAILS");
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);
        
        Passportno=new JLabel("Name");
        Passportno.setFont(new Font("Tahoma",Font.PLAIN,17));
        Passportno.setBounds(60,30,150,27);
        add(Passportno);
        
        textField=new JTextField();
        textField.setBounds(200,30,150,27);
        add(textField);
        
        Next=new JButton("SAVE");
        Next.setBackground(Color.black);
        Next.setForeground(Color.white);
        Next.setBounds(200,420,150,30);
        add(Next);
        
        Pnrno=new JLabel("AGE");
        Pnrno.setFont(new Font("Tahome",Font.PLAIN,17));
        Pnrno.setBounds(60,80,150,27);
        add(Pnrno);
        
        textField_1=new JTextField();
        textField_1.setBounds(200,80,150,27);
        add(textField_1);
        
        Gender=new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        Gender.setBounds(60,120,150,27);
        add(Gender);
        
        NewRadioButton=new JRadioButton("Male");
        NewRadioButton.setBackground(Color.white);
        NewRadioButton.setBounds(200,120,70,27);
        add(NewRadioButton);
        
        Female=new JRadioButton("Female");
        Female.setBackground(Color.white);
        Female.setBounds(280,120,70,27);
        add(Female);
        
        Address=new JLabel("JOB");
        Address.setFont(new Font("Tahoma",Font.PLAIN,17));
        Address.setBounds(60,170,150,27);
        add(Address);
        
        String course[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1=new JComboBox(course);
        c1.setBackground(Color.white);
        c1.setBounds(200,170,150,30);
        add(c1);
        
        Nationality=new JLabel("SALARY");
        Nationality.setFont(new Font("Tahoma",Font.PLAIN,17));
        Nationality.setBounds(60,220,150,27);
        add(Nationality);
        
        textField_3=new JTextField();
        textField_3.setBounds(200,220,150,27);
        add(textField_3);
        
        Name=new JLabel("PHONE");
        Name.setFont(new Font("Tahoma",Font.PLAIN,17));
        Name.setBounds(60,270,150,27);
        add(Name);
        
        textField_4=new JTextField();
        textField_4.setBounds(200,270,150,27);
        add(textField_4);
        
        Phno=new JLabel("AADHAR");
        Phno.setBounds(60,320,150,27);
        Phno.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Phno);
        
        textField_5=new JTextField();
        textField_5.setBounds(200,320,150,27);
        add(textField_5);
        
        email=new JLabel("EMAIL");
        email.setFont(new Font("Tahome",Font.PLAIN,17));
        email.setBounds(60,370,150,27);
        add(email);
        
        textField_6=new JTextField();
        textField_6.setBounds(200,370,150,27);
        add(textField_6);
        
        setVisible(true);
        
        AddPassengers=new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma",Font.PLAIN,31));
        AddPassengers.setBounds(450,24,442,35);
        add(AddPassengers);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i3);
        image=new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);
        
        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name=textField.getText();
                String age=textField_1.getText();
                String salary=textField_3.getText();
                String phone=textField_4.getText();
                String aadhar=textField_5.getText();
                String email=textField_6.getText();
                
                String gender=null;
                
                if(NewRadioButton.isSelected()){
                    gender="male";
                }else if(Female.isSelected()){
                    gender="Female";
                }
                
                String s6=(String)c1.getSelectedItem();
                
                try{
                    conn c=new conn();
                    
                    String str="INSERT INTO employee values('"+name+"','"+age+"','"+gender+"','"+s6+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
                    
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        setSize(900,600);
        setLocation(530,200);
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
