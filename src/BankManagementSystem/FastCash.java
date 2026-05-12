package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

  JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, others, back;
  String pinnumber;
  FastCash(String pinnumber){

    this.pinnumber = pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,700,700);
    add(image);

    JLabel text = new JLabel("Select Withdrawl Amount");
    text.setBounds(150,220,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);

    deposit = new JButton("Rs 100");
    deposit.setBounds(120,322,130,25);
    deposit.addActionListener(this);
    image.add(deposit);

    withdrawl = new JButton("Rs 500");
    withdrawl.setBounds(270,322,130,25);
    withdrawl.addActionListener(this);
    image.add(withdrawl);

    fastcash = new JButton("Rs 1000");
    fastcash.setBounds(120,350,130,25);
    fastcash.addActionListener(this);
    image.add(fastcash);

    ministatement = new JButton("Rs 2000");
    ministatement.setBounds(270,350,130,25);
    ministatement.addActionListener(this);
    image.add(ministatement);

    pinchange = new JButton("Rs 2500");
    pinchange.setBounds(120,378,130,25);
    pinchange.addActionListener(this);
    image.add(pinchange);

    balanceenquiry = new JButton("Rs 5000");
    balanceenquiry.setBounds(270,378,130,25);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);

    others = new JButton("Rs 10000");
    others.setBounds(120,406,130,25);
    others.addActionListener(this);
    image.add(others);

    back = new JButton("Back");
    back.setBounds(270,406,130,25);
    back.addActionListener(this);
    image.add(back);


    setSize(700, 750);
    setLocation(300, 0);
    setUndecorated(true);
    setVisible(true);


  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==back){
      setVisible(false);
      new Transaction(pinnumber).setVisible(true);
    }else{
      String amount = ((JButton)ae.getSource()).getText().substring(3);
      conn c= new conn();
      try{
        ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
        int balance = 0;
        while (rs.next()) {
          if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("amount"));
          }else{
            balance -= Integer.parseInt(rs.getString("amount"));
          }
        }

        if(ae.getSource() != back && balance < Integer.parseInt(amount)){
          JOptionPane.showMessageDialog(null, "Insufficient Balance");
          return;
        }

        Date date = new Date();
        String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Rs "+amount+"Debited Successfully");

        setVisible(false);
        new Transaction(pinnumber).setVisible(true);


      }catch(Exception e){
        System.out.println(e);
      }
    }
  }
    

  public static void main(String[] args) {
    new FastCash("");
  }

}
