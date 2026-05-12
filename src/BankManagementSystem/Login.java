package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JButton login, clear, signup;
  JTextField cardTextField ;
  JPasswordField pinTextField;

  Login() {
    setTitle("AUTOMATED TELLER MACHINE");

    setLayout(null);
    ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(72, 10, 100, 100);

    add(label);

    JLabel text = new JLabel("Welcome to ATM");
    text.setFont(new Font("Osward",Font.BOLD,38));
    text.setBounds(200, 40, 400, 40);
    add(text);

    JLabel cardNo = new JLabel("Card No:");
    cardNo.setFont(new Font("Ralway",Font.BOLD,28));
    cardNo.setBounds(120, 150, 250, 30);
    add(cardNo);

    cardTextField = new JTextField();
    cardTextField.setBounds(300, 150, 220, 30);
    cardTextField.setFont(new Font("Aerial", Font.BOLD, 14));
    add(cardTextField);

    JLabel pin = new JLabel("Pin:");
    pin.setFont(new Font("Ralway",Font.BOLD,28));
    pin.setBounds(120, 220, 400, 40);
    add(pin);

    pinTextField = new JPasswordField();
    pinTextField.setBounds(300, 220, 220, 30);
    pinTextField.setFont(new Font("Aerial", Font.BOLD, 14));
    add(pinTextField);

    login = new JButton("SIGN IN");
    login.setBounds(300, 300, 100, 30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    add(login);

    clear = new JButton("Clear");
    clear.setBounds(420, 300, 100, 30);
    clear.setBackground(Color.BLACK);
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    add(clear);

    signup = new JButton("SIGN UP");
    signup.setBounds(300, 350, 220, 30);
    signup.setBackground(Color.BLACK);
    signup.setForeground(Color.WHITE);
    signup.addActionListener(this);
    add(signup);


    getContentPane().setBackground(Color.WHITE);

    setSize(800,480);
    setVisible(true);
    setLocation(300,150);


  }
    @Override
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==clear){
        cardTextField.setText("");
        pinTextField.setText("");
      }
      else if (ae.getSource()==login){
        conn c = new conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "SELECT * FROM login WHERE cardnumber = '"+cardnumber+"' AND pinnumber = '"+pinnumber+"'";
        try{
          ResultSet rs = c.s.executeQuery(query);
          if(rs.next()){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
          }else{
            JOptionPane.showMessageDialog(null, "Incorrect Card number or pin");
          }
        }catch(Exception e){
          System.out.println(e);
        }
      }
      else if (ae.getSource()==signup){
        setVisible(false);
        new SignupOne().setVisible(true);

      }
    } 
  public static void main(String[] args) {
    new Login();
  }
}
