import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

 JFrame loginframe;
	private JTextField txtusername;
	private JPasswordField passwordField;
	Connection conn= null;
	PreparedStatement st=null;
	ResultSet rest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.getContentPane().setBackground(new Color(175, 238, 238));
		loginframe.setBounds(100, 100, 337, 345);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 71, 67, 35);
		loginframe.getContentPane().add(lblNewLabel);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your credentials to login");
		lblPleaseEnterYour.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPleaseEnterYour.setBounds(54, 12, 235, 35);
		loginframe.getContentPane().add(lblPleaseEnterYour);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 59, 324, 1);
		loginframe.getContentPane().add(separator);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(30, 117, 67, 35);
		loginframe.getContentPane().add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserType.setBounds(20, 163, 67, 35);
		loginframe.getContentPane().add(lblUserType);
		
		txtusername = new JTextField();
		txtusername.setText("Admin");
		txtusername.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtusername.setBounds(111, 72, 178, 35);
		loginframe.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JComboBox cbousertyp = new JComboBox();
		cbousertyp.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "User"}));
		cbousertyp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbousertyp.setBounds(111, 172, 178, 35);
		loginframe.getContentPane().add(cbousertyp);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn=DbConnection.dbconnection();
				String query="SELECT * FROM Users WHERE Username=? and Password=? and Usertype=?";
				
			try {
						st = conn.prepareStatement(query);
						
						st.setString(1, txtusername.getText());
						st.setString(2, passwordField.getText());
						st.setString(3, String.valueOf(cbousertyp.getSelectedItem()));
						rest=st.executeQuery();
					
						if(rest.next()) {					
														
							JOptionPane.showMessageDialog(null, "Username and password matched and you are loged in as "+""+ rest.getString("Usertype"));
							/*StudentExamGrade grad =new StudentExamGrade();
							grad.mainframe.setVisible(true);
							loginframe.dispose();
							*/
							
						if(cbousertyp.getSelectedIndex()==0) {
							
							StudentExamGrade grad =new StudentExamGrade();
							grad.mainframe.setVisible(true);
							loginframe.dispose();
						}
								
						else 	
					 {
							StudentExamGrade grad =new StudentExamGrade();
							grad.mainframe.setVisible(true);
							loginframe.dispose();
							//grad.btnDelete.removeVetoableChangeListener(false);
							//grad.btnupdategrades.setVisible(false);
							
							
						}
																																
						
						}
						else
						 {
							JOptionPane.showMessageDialog(null, "Username and password do no matche please try again "+""+ rest.getString("Usertype"));
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
		   }		
		});
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnlogin.setBounds(24, 241, 67, 35);
		loginframe.getContentPane().add(btnlogin);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtusername.setText("");
				passwordField.setText("");
				cbousertyp.setSelectedItem("");
				
			}
		});
		btnreset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnreset.setBounds(115, 241, 73, 35);
		loginframe.getContentPane().add(btnreset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginframe = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(loginframe, "Confirm if you want to exit the application","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				
				System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnExit.setBounds(212, 241, 67, 35);
		loginframe.getContentPane().add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setBounds(112, 120, 177, 32);
		loginframe.getContentPane().add(passwordField);
	}
	

	
}
