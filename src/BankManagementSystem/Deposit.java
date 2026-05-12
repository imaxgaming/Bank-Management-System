package BankManagementSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

  JButton deposit, back;
  JTextField amount;
  String pinnumber;

  Deposit(String pinnumber){

    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,700,700);
    add(image);
    JLabel text = new JLabel("Enter the amount you want to deposit.");
    text.setBounds(130,220,270,25);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,14));
    image.add(text);

    amount = new JTextField();
    amount.setFont(new Font("Ralway", Font.BOLD,16));
    amount.setBounds(130,250,270,25);
    image.add(amount);

    deposit = new JButton("Deposit");
    deposit.setBounds(270,378,130,25);
    deposit.addActionListener(this);
    image.add(deposit);

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
    if(ae.getSource()==deposit){
      String number = amount.getText();
      Date date = new Date();
      if(number.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposite");
      }else{
        try{
        conn c= new conn();
        String query = "INSERT INTO bank(pin, date, type, amount) VALUES('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Rs "+number+"Deposited Successfully");
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
    new Deposit("");
    
  }
}
