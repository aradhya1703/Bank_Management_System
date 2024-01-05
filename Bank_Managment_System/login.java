package Bank_Managment_System;

// import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//swing basically used for the development of desktop based application......

public class login extends JFrame implements ActionListener {

    JButton Login, clear, signup; // Globally defining the buttons to use anywhere in the code....
    JTextField cardTextField;
    JPasswordField pinTextField;

    login() {
        setTitle("Automated Teller Machine, developed by- aradhya");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank_Managment_System/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); // JLabel used to write any type content on the page....n also put images....
        label.setBounds(70, 10, 100, 100);
        add(label); //

        JLabel text = new JLabel("Welcome To A_ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        Login = new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE); // to change the background color...

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        // initialize the buttons that what action the event will perform when clicked
        // or triggered...

        if (ae.getSource() == clear) {
            cardTextField.setText(""); // so that it will get empty when clicked.....
            pinTextField.setText("");
        } else if (ae.getSource() == Login) {
           Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText();
           String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
           try{
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
           } catch (Exception e){
            System.out.println(e);
           }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            SignupOne su = new SignupOne();
            su.setVisible(true);

        }

    }

    public static void main(String args[]) {
        new login(); // object for the class login.....
    }
}
