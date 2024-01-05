package Bank_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame  implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField,dateTextField, emailTextField, addressTextField, stateTextField, cityTextField,pincodeTextField;
    JButton next;
    JRadioButton male ,female, married, single;

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000) + 1000L);

        JLabel formno = new JLabel("Application Form No. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD , 38));
        formno.setBounds(140 , 20 , 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page-1:Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD , 22));
        personalDetails.setBounds(290 , 80 , 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD , 20));
        name.setBounds(100 , 140 , 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD , 20));
        fname.setBounds(100 , 190 , 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD , 20));
        dob.setBounds(100 , 240 , 200, 30);
        add(dob);

        dateTextField = new JTextField();
        dateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dateTextField.setBounds(300, 240, 400, 30);
        add(dateTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD , 20));
        gender.setBounds(100 , 290 , 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(female);        
        gendergroup.add(male);

        JLabel email= new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD , 20));
        email.setBounds(100 , 340 , 300, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD , 20));
        marital.setBounds(100 , 390 , 300, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(450,390,120,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalstatus = new ButtonGroup();
        maritalstatus.add(married);        
        maritalstatus.add(single);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD , 20));
        address.setBounds(100 , 440 , 300, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD , 20));
        city.setBounds(100 , 490 , 300, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD , 20));
        state.setBounds(100 , 540 , 300, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode= new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD , 20));
        pincode.setBounds(100 , 590 , 300, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font ("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        String formno = " "+random; // using this double quotes and concatenate then it converts to string....
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dateTextField.getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(single.isSelected()){
            marital = "Single";
        }


        if(ae.getSource() == next){
            setVisible(false);
            Signup2 s2 = new Signup2(formno);
            s2.setVisible(true);

        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();



        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+email+"' , '"+marital+"', '"+gender+"' , '"+pincode+"' , '"+state+"' , '"+city+"', '"+address+"')";
                c.s.executeUpdate(query); // dml (data manipulation)command to execute the query... 
                // used the object of Conn class to establish the mySql connection...
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main (String args[]){
        new SignupOne(); // object of the class SignupOne...
    }
}
