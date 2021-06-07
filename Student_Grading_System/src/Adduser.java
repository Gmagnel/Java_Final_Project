import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Adduser {

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField passwordFieldadduser;
	
	Connection conn= DbConnection.dbconnection();
	PreparedStatement pst = null;
	ResultSet rs=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adduser window = new Adduser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Adduser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 347, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUserName.setBounds(20, 60, 61, 25);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblUserType = new JLabel("User type");
		lblUserType.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUserType.setBounds(30, 134, 51, 25);
		frame.getContentPane().add(lblUserType);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassword.setBounds(20, 98, 61, 25);
		frame.getContentPane().add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtusername.setColumns(10);
		txtusername.setBounds(98, 57, 194, 31);
		frame.getContentPane().add(txtusername);
		
		JComboBox cboadduser = new JComboBox();
		cboadduser.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "User"}));
		cboadduser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cboadduser.setBounds(98, 135, 194, 31);
		frame.getContentPane().add(cboadduser);
		
		passwordFieldadduser = new JPasswordField();
		passwordFieldadduser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passwordFieldadduser.setBounds(98, 96, 194, 25);
		frame.getContentPane().add(passwordFieldadduser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 33, 331, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-10, 202, 331, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnadduser = new JButton("Add user");
		btnadduser.addActionListener(new ActionListener() {
			private JLabel txtfmobile;

			public void actionPerformed(ActionEvent e) {
				
				
				
String query= "INSERT INTO Users(Username,Usertype,Password) VALUES(?,?,?)";
				
				if (txtusername.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"Fields are requireq");
				}
				else {
					
					
				
				try {
					pst = conn.prepareStatement(query);
					pst.setString(1, txtusername.getText());
					pst.setString(2, (String) cboadduser.getSelectedItem());
					pst.setString(3,passwordFieldadduser.getText());
									
					pst.execute();
					
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				}
				
				JOptionPane.showMessageDialog(null, "New user has beeb confirmed successfully!","Student Grading System", JOptionPane.YES_NO_OPTION);
				
				
				
				
			}
		});
		btnadduser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnadduser.setBounds(4, 215, 89, 33);
		frame.getContentPane().add(btnadduser);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReset.setBounds(122, 216, 89, 32);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(221, 216, 71, 32);
		frame.getContentPane().add(btnExit);
		
		JLabel lblPleaseAddNew = new JLabel("Please add new user to the system");
		lblPleaseAddNew.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPleaseAddNew.setBounds(50, 11, 242, 20);
		frame.getContentPane().add(lblPleaseAddNew);
	}
}
