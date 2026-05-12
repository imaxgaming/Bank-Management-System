package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener  {

  JButton change, back;
  JPasswordField pin, repin;
  String pinnumber;

  PinChange(String pinnumber){

    this.pinnumber = pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,700,700);
    add(image);

    JLabel text = new JLabel("Change Your Pin");
    text.setBounds(190,220,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);

    JLabel pintext = new JLabel("New Pin: ");
    pintext.setBounds(130,260,200,35);
    pintext.setForeground(Color.WHITE);
    pintext.setFont(new Font("System", Font.BOLD,14));
    image.add(pintext);

    pin = new JPasswordField();
    pin.setFont(new Font("System", Font.BOLD,14));
    pin.setBounds(270,260,130,25);
    image.add(pin);

    JLabel repintext = new JLabel("Re-Enter New Pin: ");
    repintext.setBounds(130,290,200,35);
    repintext.setForeground(Color.WHITE);
    repintext.setFont(new Font("System", Font.BOLD,14));
    image.add(repintext);

    repin = new JPasswordField();
    repin.setFont(new Font("System", Font.BOLD,14));
    repin.setBounds(270,290,130,25);
    image.add(repin);

    change = new JButton("Change");
    change.setBounds(270,378,130,25);
    change.addActionListener(this);
    image.add(change);

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
   if(ae.getSource()==change){
    try{
      String npin = pin.getText();
      String rpin = repin.getText();
      if(!npin.equals(rpin)){
        JOptionPane.showMessageDialog(null, "Entered pin does not match");
        return;
      }
      
      if(npin.equals("")){
        JOptionPane.showMessageDialog(null, "Please Enter new pin");
        return;
      }
      if(rpin.equals("")){
        JOptionPane.showMessageDialog(null, "Please Re-Enter new pin");
        return;
      }

      conn c = new conn();
      String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'"; 
      String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'"; 
      String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'"; 

      c.s.executeUpdate(query1);
      c.s.executeUpdate(query2);
      c.s.executeUpdate(query3);

      JOptionPane.showMessageDialog(null,"Pin Change Successfully");

      setVisible(false);
      new Transaction(rpin).setVisible(true);

    }catch(Exception e){
      System.out.println(e);
    }
   }else{
    setVisible(false);
    new Transaction(pinnumber).setVisible(true);
   }
    

  }

  public static void main(String[] args) {
    new PinChange("");
  }
}
