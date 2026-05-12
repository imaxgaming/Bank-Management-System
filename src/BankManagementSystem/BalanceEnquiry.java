package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

  String pinnumber;
  JButton back;

  BalanceEnquiry(String pinnumber){
    this.pinnumber = pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,700,700);
    add(image);


    back = new JButton("Back");
    back.setBounds(270,406,130,25);
    back.addActionListener(this);
    image.add(back);

    conn c= new conn();
    int balance = 0;
      try{
        ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
        while (rs.next()) {
          if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("amount"));
          }else{
            balance -= Integer.parseInt(rs.getString("amount"));
          }
        }
      }catch(Exception e){
          System.out.println(e);
      }

      JLabel text = new JLabel("Your account balance is "+balance);
      text.setBounds(130,260,200,35);
      text.setForeground(Color.WHITE);
      // text.setFont(new Font("System", Font.BOLD,16));
      image.add(text);



    setSize(700, 750);
    setLocation(300, 0);
    setUndecorated(true);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Transaction(pinnumber).setVisible(true);
  }

  public static void main(String[] args) {
    new BalanceEnquiry("");
  }
}
