package BankManagementSystem;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

JTextField pan, aadhar;
JButton next;
JRadioButton sYes, sNo, eYes, eNo;
JComboBox religion, category, occupation, education, income;
String formno;

SignupTwo (String formno){

  this.formno = formno;
  setLayout(null);

  setTitle("New Account Application Form - Page 2");

  JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
  additionaldetails.setFont(new Font("raleway", Font.BOLD, 22));
  additionaldetails.setBounds(290, 80, 400, 30);
  add(additionaldetails);

  JLabel chooseReligion = new JLabel("Religion : ");
  chooseReligion.setFont(new Font("raleway", Font.BOLD, 20));
  chooseReligion.setBounds(100, 140, 100, 30);
  add(chooseReligion);

  String valReligion [] = {"Hindu","Islam","Sikh","Christian","Other"};
  religion = new JComboBox(valReligion);
  religion.setBounds(300, 140, 400, 30);
  religion.setBackground(Color.WHITE);
  add(religion);


  JLabel chooseCategory = new JLabel("Category : ");
  chooseCategory.setFont(new Font("raleway", Font.BOLD, 20));
  chooseCategory.setBounds(100, 190, 200, 30);
  add(chooseCategory);

  String valCategory [] = {"General","OBC","SC","ST","Other"};
  category = new JComboBox(valCategory);
  category.setBounds(300, 190, 400, 30);
  category.setBackground(Color.WHITE);
  add(category);


  JLabel chooseIncome = new JLabel("Income : ");
  chooseIncome.setFont(new Font("raleway", Font.BOLD, 20));
  chooseIncome.setBounds(100, 240, 200, 30);
  add(chooseIncome);

  String valIncome [] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
  income = new JComboBox(valIncome);
  income.setBounds(300, 240, 400, 30);
  income.setBackground(Color.WHITE);
  add(income);


  JLabel chooseEdu = new JLabel("Educational ");
  chooseEdu.setFont(new Font("raleway", Font.BOLD, 20));
  chooseEdu.setBounds(100, 290, 200, 30);
  add(chooseEdu);


  JLabel chooseQual = new JLabel("Qualification : ");
  chooseQual.setFont(new Font("raleway", Font.BOLD, 20));
  chooseQual.setBounds(100, 315, 200, 30);
  add(chooseQual);

  String educationValue [] = {"Non Graduate","Graduate","Post Graduate","Doctorate","Others"};
  education = new JComboBox(educationValue);
  education.setBounds(300, 315, 400, 30);
  education.setBackground(Color.WHITE);
  add(education);


  JLabel chooseOccupation = new JLabel("Occupation : ");
  chooseOccupation.setFont(new Font("raleway", Font.BOLD, 20));
  chooseOccupation.setBounds(100, 390, 200, 30);
  add(chooseOccupation);

  String occupationValue [] = {"Salleried ","Self Employed","Business ","Retired","Student","Others"};
  occupation = new JComboBox(occupationValue);
  occupation.setBounds(300, 390, 400, 30);
  occupation.setBackground(Color.WHITE);
  add(occupation);
  


 

  JLabel panNumber = new JLabel("Pan Number : ");
  panNumber.setFont(new Font("raleway", Font.BOLD, 20));
  panNumber.setBounds(100, 440, 200, 30);
  add(panNumber);

  pan = new JTextField();
  pan.setFont(new Font("raleway", Font.BOLD, 14));
  pan.setBounds(300, 440, 400, 30);
  add(pan);

  JLabel aadharNumber = new JLabel("Aadhar Number : ");
  aadharNumber.setFont(new Font("raleway", Font.BOLD, 20));
  aadharNumber.setBounds(100, 490, 200, 30);
  add(aadharNumber);

  aadhar = new JTextField();
  aadhar.setFont(new Font("raleway", Font.BOLD, 14));
  aadhar.setBounds(300, 490, 400, 30);
  add(aadhar);

  JLabel sCitizen = new JLabel("Senior Citizen : ");
  sCitizen.setFont(new Font("raleway", Font.BOLD, 20));
  sCitizen.setBounds(100, 540, 200, 30);
  add(sCitizen);

  sYes = new JRadioButton("Yes");
  sYes.setBounds(300, 540, 100, 30);
  sYes.setBackground( Color.WHITE);
  add(sYes);

  sNo = new JRadioButton("No");
  sNo.setBounds(450, 540, 100, 30);
  sNo.setBackground( Color.WHITE);
  add(sNo);

  ButtonGroup scitizengroup= new ButtonGroup();
  scitizengroup.add(sYes);
  scitizengroup.add(sNo);


  JLabel pincode = new JLabel("Existing Account : ");
  pincode.setFont(new Font("raleway", Font.BOLD, 20));
  pincode.setBounds(100, 590, 200, 30);
  add(pincode);

  eYes = new JRadioButton("Yes");
  eYes.setBounds(300, 590, 100, 30);
  eYes.setBackground( Color.WHITE);
  add(eYes);

  eNo = new JRadioButton("No");
  eNo.setBounds(450, 590, 100, 30);
  eNo.setBackground( Color.WHITE);
  add(eNo);

  ButtonGroup existingacgroup= new ButtonGroup();
  existingacgroup.add(eYes);
  existingacgroup.add(eNo);


  next = new JButton("Next");
  next.setBackground(Color.BLACK);
  next.setForeground(Color.WHITE);
  next.setBounds(620, 640, 80, 30);
  next.addActionListener(this);
  add(next);

  getContentPane().setBackground(Color.WHITE);

  setSize(850,800);
  setLocation(350,0);
  setVisible(true);

}

public void actionPerformed(ActionEvent ae){
  String sreligion = (String) religion.getSelectedItem();
  String scategory = (String) category.getSelectedItem();
  String sincome = (String) income.getSelectedItem();
  String seducation = (String) education.getSelectedItem();
  String soccupation = (String) occupation.getSelectedItem();

  String seniorCitizen = null;
  if(sYes.isSelected()){
    seniorCitizen = "Yes";
  }else if (sNo.isSelected()){
    seniorCitizen = "No";
  }

  String existingAccount = null;
  if(eYes.isSelected()){
    existingAccount = "Yes";
  }else if(eNo.isSelected()){
    existingAccount = "No";
  }
  String span = pan.getText();
  String saadhar = aadhar.getText();


  try {
   
      conn c = new conn();
      String query = "INSERT INTO signuptwo VALUES('" + formno + "','" + sreligion + "', '" + scategory + "', '" + soccupation + "','" + seducation + "','" + sincome + "','" + span + "','" + saadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
      c.s.executeUpdate(query);

      // SignupThree object
      setVisible(false);
      new SignupThree(formno).setVisible(true);
  } catch (Exception e) {
    System.out.println(e);
  }
}

public static void main(String[] args) {
  new SignupTwo("");
}
}

