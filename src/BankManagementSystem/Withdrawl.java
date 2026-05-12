package BankManagementSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

  JButton withdraw, back;
  JTextField amount;
  String pinnumber;

  Withdrawl(String pinnumber){

    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,700,700);
    add(image);
    JLabel text = new JLabel("Enter the amount you want to withdraw.");
    text.setBounds(130,220,270,25);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,14));
    image.add(text);

    amount = new JTextField();
    amount.setFont(new Font("Ralway", Font.BOLD,16));
    amount.setBounds(130,250,270,25);
    image.add(amount);

    withdraw = new JButton("Withdraw");
    withdraw.setBounds(270,378,130,25);
    withdraw.addActionListener(this);
    image.add(withdraw);

    back = new JButton("Back");
    back.setBounds(270,406,130,25);
    back.addActionListener(this);
    image.add(back);

    setSize(700, 750);
    setLocation(300, 0);
    // setUndecorated(true);
    setVisible(true);
  }


  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==withdraw){
      String number = amount.getText();
      Date date = new Date();
      if(number.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
      }else{
        try{
        conn c= new conn();
        String query = "INSERT INTO bank(pin, date, type, amount) VALUES('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Rs "+number+"Withdraw Successfully");
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
       

      }

    }else if(ae.getSource()==back){
      setVisible(false);
      new Transaction(pinnumber).setVisible(true);
    }
  }
  public static void main(String[] args) {
    new Withdrawl("");
    
  }
}
