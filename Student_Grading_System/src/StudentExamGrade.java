import java.awt.EventQueue;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout.Alignment;
import java.awt.ComponentOrientation;
public class StudentExamGrade {

	JFrame mainframe;
	private JTextField txtID;
	private JTextField txtfname;
	private JTextField txtsname;
	private JTextField txtexam;
	private JTextField txtTotalscore;
	private JTextField txtAverage;
	private JTextField txtRank;
	private JTextField txtjava;
	private JTextField txtCsharp;
	private JTextField txtCss;
	private JTextField txtSqlite;
	private JTextField txtVB;
	private JTextField txtPhp;
	private JTextField txtGit;
	private JTextField txtpython;
	
	Connection conn =DbConnection.dbconnection();
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btntran;
	private JButton btnPrint;
	private JScrollPane scrollPane;
	private JButton btnResult;
	public JButton btnupdategrades;
	public JButton btnDelete;
	private JButton btnReset;
	private JButton btnExit;
	
	
	
	/**
	 * Launch the application.
	
	 */
	
	
	// Select StudentID,Coursecode,Java,Csharp,Css,Sqlite,Visualbasic,Php,Github,Python ,Totalscore,Average,Ranking 
	public void updateTable() {
		
		//conn = DbConnection.dbconnection();
		if (conn !=null) {
			String sql="Select StudentID,Coursecode,Examcode,FName,SName,Java,Csharp,Css,Sqlite,Visualbasic,Php,Github,Python,Totalscore,Average,Ranking FROM Grading";
		try
		{
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Object[] columnData= new Object[16];
			while(rs.next()){
				columnData[0]=rs.getString("StudentID");
				columnData[1]=rs.getString("Coursecode");
				columnData[2]=rs.getString("Examcode");
				columnData[3]=rs.getString("FName");
				columnData[4]=rs.getString("SName");
				columnData[5]=rs.getString("Java");
				columnData[6]=rs.getString("Csharp");
				columnData[7]=rs.getString("Css");
				columnData[8]=rs.getString("Sqlite");
				columnData[9]=rs.getString("Visualbasic");
				columnData[10]=rs.getString("Php");
				columnData[11]=rs.getString("Github");
				columnData[12]=rs.getString("Python");
				columnData[13]=rs.getString("Totalscore");
				columnData[14]=rs.getString("Average");
				columnData[15]=rs.getString("Ranking");
				model.addRow(columnData);
			
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentExamGrade window = new StudentExamGrade();
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentExamGrade() {
		initialize();
		
		/*if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you want to connect to the database","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
		{
			 
			
		
		
		
	//	if(JOptionPane.showConfirmDialog(frame, c))
		
		
		
}else {
			System.exit(0);
		}
		*/
		Object col[]= {"StudentID","Coursecode","Examcode","FName","SName","Java","Csharp","Css","Sqlite","Visualbasic","Php","Github","Python","Totalscore","Average","Ranking"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
		mainframe.getContentPane().setLayout(null);
		mainframe.getContentPane().add(panel);
		mainframe.getContentPane().add(panel_1);
		mainframe.getContentPane().add(btnupdategrades);
		mainframe.getContentPane().add(btnResult);
		mainframe.getContentPane().add(btntran);
		mainframe.getContentPane().add(btnPrint);
		mainframe.getContentPane().add(btnReset);
		mainframe.getContentPane().add(btnExit);
		mainframe.getContentPane().add(btnDelete);
		mainframe.getContentPane().add(scrollPane);
		
		
		updateTable();
	}

	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		mainframe = new JFrame();
		mainframe.getContentPane().setFocusTraversalPolicyProvider(true);
		mainframe.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mainframe.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		mainframe.getContentPane().setBackground(new Color(153, 204, 204));
		mainframe.setBounds(0, 0, 1060, 692);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 642, 370);
		panel.setBackground(new Color(153, 204, 204));
		panel.setBorder(new LineBorder(new Color(216, 191, 216), 4));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(54, 41, 75, 17);
		panel.add(lblNewLabel);
		
		JLabel lblFisrtname = new JLabel("FisrtName");
		lblFisrtname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFisrtname.setBounds(54, 84, 75, 17);
		panel.add(lblFisrtname);
		
		JLabel lblSurname = new JLabel("SurName");
		lblSurname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSurname.setBounds(54, 127, 75, 17);
		panel.add(lblSurname);
		
		JLabel lblCoursecode = new JLabel("CourseCode");
		lblCoursecode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCoursecode.setBounds(54, 170, 75, 17);
		panel.add(lblCoursecode);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ranking");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(54, 332, 75, 17);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblExamNo = new JLabel("Exam No.");
		lblExamNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblExamNo.setBounds(54, 213, 75, 17);
		panel.add(lblExamNo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Score");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(54, 248, 75, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Average");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(54, 291, 75, 17);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Python");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(353, 328, 50, 17);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("VB");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(378, 209, 25, 17);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PHP");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(378, 244, 33, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("GitHub");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(353, 287, 50, 17);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Sqlite");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(362, 166, 41, 17);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("CSS");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(370, 123, 33, 17);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("C#");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(370, 80, 33, 17);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblJava = new JLabel("Java");
		lblJava.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblJava.setBounds(370, 40, 33, 17);
		panel.add(lblJava);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtID.setBounds(139, 32, 187, 30);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtfname.setColumns(10);
		txtfname.setBounds(139, 76, 187, 30);
		panel.add(txtfname);
		
		txtsname = new JTextField();
		txtsname.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtsname.setColumns(10);
		txtsname.setBounds(139, 120, 187, 30);
		panel.add(txtsname);
		
		txtexam = new JTextField();
		txtexam.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtexam.setColumns(10);
		txtexam.setBounds(139, 204, 187, 30);
		panel.add(txtexam);
		
		txtTotalscore = new JTextField();
		txtTotalscore.setBackground(new Color(220, 220, 220));
		txtTotalscore.setEditable(false);
		txtTotalscore.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtTotalscore.setColumns(10);
		txtTotalscore.setBounds(139, 243, 106, 29);
		panel.add(txtTotalscore);
		
		txtAverage = new JTextField();
		txtAverage.setBackground(new Color(220, 220, 220));
		txtAverage.setEditable(false);
		txtAverage.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtAverage.setColumns(10);
		txtAverage.setBounds(139, 286, 106, 30);
		panel.add(txtAverage);
		
		txtRank = new JTextField();
		txtRank.setBackground(new Color(220, 220, 220));
		txtRank.setEditable(false);
		txtRank.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtRank.setColumns(10);
		txtRank.setBounds(139, 327, 187, 30);
		panel.add(txtRank);
		
		txtjava = new JTextField();
		txtjava.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtjava.setColumns(10);
		txtjava.setBounds(422, 32, 194, 30);
		panel.add(txtjava);
		
		txtCsharp = new JTextField();
		txtCsharp.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtCsharp.setColumns(10);
		txtCsharp.setBounds(422, 75, 194, 30);
		panel.add(txtCsharp);
		
		txtCss = new JTextField();
		txtCss.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtCss.setColumns(10);
		txtCss.setBounds(422, 118, 194, 30);
		panel.add(txtCss);
		
		txtSqlite = new JTextField();
		txtSqlite.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtSqlite.setColumns(10);
		txtSqlite.setBounds(422, 161, 194, 30);
		panel.add(txtSqlite);
		
		txtVB = new JTextField();
		txtVB.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtVB.setColumns(10);
		txtVB.setBounds(422, 204, 194, 30);
		panel.add(txtVB);
		
		txtPhp = new JTextField();
		txtPhp.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtPhp.setColumns(10);
		txtPhp.setBounds(422, 239, 194, 30);
		panel.add(txtPhp);
		
		txtGit = new JTextField();
		txtGit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtGit.setColumns(10);
		txtGit.setBounds(422, 282, 194, 30);
		panel.add(txtGit);
		
		txtpython = new JTextField();
		txtpython.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtpython.setColumns(10);
		txtpython.setBounds(422, 322, 194, 31);
		panel.add(txtpython);
		
		JComboBox comboBoxcorse = new JComboBox();
		comboBoxcorse.setModel(new DefaultComboBoxModel(new String[] {"", "JPL0401", "JPL0502", "JPL0703", "JPL0904", "JPL8705", "JPL0116", "JPL0407", "JPL1248"}));
		comboBoxcorse.setBounds(139, 163, 187, 30);
		panel.add(comboBoxcorse);
		
		JLabel lblPleaseEnterThe = new JLabel("PLEASE ENTER THE STUDENT GRADES");
		lblPleaseEnterThe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPleaseEnterThe.setBounds(214, 11, 261, 17);
		panel.add(lblPleaseEnterThe);
		
		panel_1 = new JPanel();
		panel_1.setBounds(662, 11, 355, 326);
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new LineBorder(new Color(216, 191, 216), 4));
		panel_1.setLayout(null);
		
		JTextArea txtTranx = new JTextArea();
		txtTranx.setBackground(new Color(204, 204, 204));
		txtTranx.setWrapStyleWord(true);
		txtTranx.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtTranx.setEditable(false);
		txtTranx.setBounds(10, 11, 335, 304);
		panel_1.add(txtTranx);
		
		
		btnupdategrades = new JButton("Update Grade");
		btnupdategrades.setBackground(new Color(32, 178, 170));
		btnupdategrades.setBounds(287, 618, 125, 33);
		btnupdategrades.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnupdategrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(txtID.getText().isEmpty()|| comboBoxcorse.getSelectedItem().toString().isEmpty()|| txtfname.getText().isEmpty()|| txtexam.getText().isEmpty()||txtjava.getText().isEmpty()|| txtCsharp.getText().isEmpty()|| txtCss.getText().isEmpty()||
						txtSqlite.getText().isEmpty()||txtVB.getText().isEmpty()||
			txtGit.getText().isEmpty()|| txtpython.getText().isEmpty()) {
		
		JOptionPane.showMessageDialog(null, "Please all fields rquire input before updating the student's grade");
		
				}else  {
					
					
				
		double [] R = new double[16];
		R[0] = Double.parseDouble(txtjava.getText());
		R[1] = Double.parseDouble(txtCsharp.getText());
		R[2] = Double.parseDouble(txtCss.getText());
		R[3] = Double.parseDouble(txtSqlite.getText());
		R[4] = Double.parseDouble(txtVB.getText());
		R[5] = Double.parseDouble(txtPhp.getText());
		R[6] = Double.parseDouble(txtGit.getText());
		R[7] = Double.parseDouble(txtpython.getText());
		
		
		//calculating the average 
		
		R[8] =(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7])/8;
		
		//calculating the total score
		R[9] =(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7]);
				
		//to display the result into the average text field
		String Average = String.format("%.0f", R[8]);
		txtAverage.setText(Average);
		//to display the result into the Total score text field
		String Totalscore = String.format("%.0f", R[9]);
		txtTotalscore.setText(Totalscore);
		
		//ranking the student by using the total score
		if (R[9] >= 700) {
			
			txtRank.setText("1ST class");
			
		}
		else if(R[9] >= 600) 
		{
			
				txtRank.setText("2ND class U");
		}
		
		else if(R[9] >= 500)
		{
			
			txtRank.setText("2ND class L");
			
		}	
		
		else if(R[9] >= 400)
		{
			
			txtRank.setText("Pass");
			
		}
		
		else if(R[9] < 400)
		{
			
			txtRank.setText("Failed");
			
		}
		
		//StudentID,Coursecode,Examcode,FName,SName,Java,Csharp,Css,Sqlite,Visualbasic,Php,Github,Python,Totalscore,Average,Ranking FROM Grading
		if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you really want to update student's grades","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
			
			String updat= "UPDATE Grading SET Coursecode=?,Examcode=?,FName=?,SName=?,Java=?,Csharp=?,Css=?,Sqlite=?,Visualbasic=?,Php=?,Github=?,Python=? ,Totalscore=?,Average=?,Ranking=? WHERE StudentID='" +txtID.getText() +"' ";
			
			
			
			try {
				pst = conn.prepareStatement(updat);
				
				//pst.setString(1, txtID.getText());
				pst.setString(1, (String) comboBoxcorse.getSelectedItem());
				pst.setString(2, txtexam.getText());
				pst.setString(3, txtfname.getText());
				pst.setString(4, txtsname.getText());
				pst.setString(5, txtjava.getText());
				pst.setString(6,txtCsharp.getText());
				pst.setString(7, txtCss.getText());
				pst.setString(8, txtSqlite.getText());
				pst.setString(9, txtVB.getText());
				pst.setString(10, txtPhp.getText());
				pst.setString(11, txtGit.getText());
				pst.setString(12, txtpython.getText());
				pst.setString(13,txtTotalscore.getText());
				pst.setString(14, txtAverage.getText());
				pst.setString(15, txtRank.getText());
				
				pst.execute();
				rs.close();
				pst.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				//JOptionPane.showMessageDialog(null, "Student Update confirmed","Student Grading System", JOptionPane.OK_OPTION);
			}
		//==================database to display on the table=======================
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.addRow(new Object[] {
					txtID.getText(),
					comboBoxcorse.getSelectedItem(),
					txtexam.getText(),
					txtfname.getText(),
					txtsname.getText(),
					txtjava.getText(),
					txtCsharp.getText(),
					txtCss.getText(),
					txtSqlite.getText(),
					txtVB.getText(),
					txtPhp.getText(),
					txtGit.getText(),
					txtpython.getText(),
					txtTotalscore.getText(), 
					txtAverage.getText(), 
					txtRank.getText(),
					
			});
						
			if (table.getSelectedRow()==-1) {
				
				if(table.getRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "No student grades updated","Student Grading System", JOptionPane.OK_OPTION);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Student grades updated successfully","Student Grading System", JOptionPane.OK_OPTION);
				
				
				txtTranx.setText("");
				txtTranx.append("\tStudent Grading System\n"
						+ "\n\t*******************************\n"
						+ "\tStudent ID:\t" + txtID.getText()
						+ "\n\tCourse code:\t" +  comboBoxcorse.getSelectedItem()
						+ "\n\tExams Code:\t"  + txtexam.getText()
						+ "\n\tFirst Name:\t" + txtfname.getText()
						+ "\n\tSurName:\t" + txtsname.getText()
						+ "\n\tJava:\t" + txtjava.getText()
						+ "\n\tC#:\t" + txtCsharp.getText()
						+ "\n\tCss:\t" + txtCss.getText()
						+ "\n\tSqlite:\t" + txtSqlite.getText()
						+ "\n\tVisualbasic:\t" + txtVB.getText()
						
						+ "\n\tPhp:\t" + txtPhp.getText()
						
						+ "\n\tGithub:\t" + txtGit.getText()
						
						+ "\n\tPython:\t" + txtpython.getText()
						
						+ "\n\t*******************************\n"
						
						+ "\n\tTotal Score:\t" + txtTotalscore.getText()
						+ "\n\tAverage:\t" + txtAverage.getText()
						+ "\n\tRanking:\t" + txtRank.getText()
						
						+ "\n");
				txtID.setText("");
				comboBoxcorse.setSelectedIndex(0);
				txtexam.setText("");
				txtfname.setText("");
				txtsname.setText("");
				txtjava.setText("");
				txtCsharp.setText("");
				txtCss.setText("");
				txtSqlite.setText("");
				txtVB.setText("");
				txtPhp.setText("");
				txtGit.setText("");
				txtpython.setText("");
				txtTotalscore.setText(""); 
				txtAverage.setText(""); 
				txtRank.setText("");
				if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you will like to print updated student's grade\n You can print it later by clicking/selecting row of the updated\nstudent and click on print button from print panel  ","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					
				MessageFormat header = new MessageFormat("Printing in progress");
				MessageFormat footer = new MessageFormat("Page (0, number, integer)");
				try{
					txtTranx.print();
					
				}catch(java.awt.print.PrinterException ev) {
					System.err.format("no printer found", ev.getMessage());
					
				}
				
				txtTranx.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, "You couldn't print updated result of the student!","Student Grading System", JOptionPane.OK_OPTION);
			
				
				
			}
				
			}
			
			
			
			}else {
				JOptionPane.showMessageDialog(null, "No student update grades confirmed","Student Grading System", JOptionPane.OK_OPTION);
						
	}
		
		}
			
			}
		});
		
		
		btnResult = new JButton("Student Result");
		btnResult.setBounds(96, 618, 136, 33);
		btnResult.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
					if(txtID.getText().isEmpty()|| comboBoxcorse.getSelectedItem().toString().isEmpty()|| txtfname.getText().isEmpty()|| txtexam.getText().isEmpty()||txtjava.getText().isEmpty()|| txtCsharp.getText().isEmpty()|| txtCss.getText().isEmpty()||
							txtSqlite.getText().isEmpty()||txtVB.getText().isEmpty()||
				txtGit.getText().isEmpty()|| txtpython.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Please all fields rquire input");
			
					}else  {
						
						
					
			double [] R = new double[16];
			R[0] = Double.parseDouble(txtjava.getText());
			R[1] = Double.parseDouble(txtCsharp.getText());
			R[2] = Double.parseDouble(txtCss.getText());
			R[3] = Double.parseDouble(txtSqlite.getText());
			R[4] = Double.parseDouble(txtVB.getText());
			R[5] = Double.parseDouble(txtPhp.getText());
			R[6] = Double.parseDouble(txtGit.getText());
			R[7] = Double.parseDouble(txtpython.getText());
			
			
			//calculating the average 
			
			R[8] =(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7])/8;
			
			//calculating the total score
			R[9] =(R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7]);
					
			//to display the result into the average text field
			String Average = String.format("%.0f", R[8]);
			txtAverage.setText(Average);
			//to display the result into the Total score text field
			String Totalscore = String.format("%.0f", R[9]);
			txtTotalscore.setText(Totalscore);
			
			//ranking the student by using the total score
			if (R[9] >= 700) {
				
				txtRank.setText("1ST class");
				
			}
			else if(R[9] >= 600) 
			{
				
					txtRank.setText("2ND class U");
			}
			
			else if(R[9] >= 500)
			{
				
				txtRank.setText("2ND class L");
				
			}	
			
			else if(R[9] >= 400)
			{
				
				txtRank.setText("Pass");
				
			}
			
			else if(R[9] < 400)
			{
				
				txtRank.setText("Failed");
				
			}
			
			//StudentID,Coursecode,Examcode,FName,SName,Java,Csharp,Css,Sqlite,Visualbasic,Php,Github,Python,Totalscore,Average,Ranking FROM Grading
			if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you really want to add student's grades","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				
				String query= "INSERT INTO Grading(StudentID,Coursecode,Examcode,FName,SName,Java,Csharp,Css,Sqlite,Visualbasic,Php,Github,Python,Totalscore,Average,Ranking) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				try {
					pst = conn.prepareStatement(query);
					
					pst.setString(1, txtID.getText());
					pst.setString(2, (String) comboBoxcorse.getSelectedItem());
					pst.setString(3, txtexam.getText());
					pst.setString(4, txtfname.getText());
					pst.setString(5, txtsname.getText());
					pst.setString(6, txtjava.getText());
					pst.setString(7,txtCsharp.getText());
					pst.setString(8, txtCss.getText());
					pst.setString(9, txtSqlite.getText());
					pst.setString(10, txtVB.getText());
					pst.setString(11, txtPhp.getText());
					pst.setString(12, txtGit.getText());
					pst.setString(13, txtpython.getText());
					pst.setString(14,txtTotalscore.getText());
					pst.setString(15, txtAverage.getText());
					pst.setString(16, txtRank.getText());
					
					pst.execute();
					rs.close();
					pst.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(null, "Student Update confirmed","Student Grading System", JOptionPane.OK_OPTION);
				}
			//==================database to display on the table=======================
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				model1.addRow(new Object[] {
						txtID.getText(),
						comboBoxcorse.getSelectedItem(),
						txtexam.getText(),
						txtfname.getText(),
						txtsname.getText(),
						txtjava.getText(),
						txtCsharp.getText(),
						txtCss.getText(),
						txtSqlite.getText(),
						txtVB.getText(),
						txtPhp.getText(),
						txtGit.getText(),
						txtpython.getText(),
						txtTotalscore.getText(), 
						txtAverage.getText(), 
						txtRank.getText(),
						
				});
							
				if (table.getSelectedRow()==-1) {
					
					if(table.getRowCount()==0)
					{
						JOptionPane.showMessageDialog(null, "No student grades confirmed","Student Grading System", JOptionPane.OK_OPTION);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Student grades confirmed successfully","Student Grading System", JOptionPane.OK_OPTION);
					
					
					txtTranx.setText("");
					txtTranx.append("\tStudent Grading System\n"
							+ "\n\t*******************************\n"
							+ "\tStudent ID:\t" + txtID.getText()
							+ "\n\tCourse code:\t" +  comboBoxcorse.getSelectedItem()
							+ "\n\tExams Code:\t"  + txtexam.getText()
							+ "\n\tFirst Name:\t" + txtfname.getText()
							+ "\n\tSurName:\t" + txtsname.getText()
							+ "\n\tJava:\t" + txtjava.getText()
							+ "\n\tC#:\t" + txtCsharp.getText()
							+ "\n\tCss:\t" + txtCss.getText()
							+ "\n\tSqlite:\t" + txtSqlite.getText()
							+ "\n\tVisualbasic:\t" + txtVB.getText()
							
							+ "\n\tPhp:\t" + txtPhp.getText()
							
							+ "\n\tGithub:\t" + txtGit.getText()
							
							+ "\n\tPython:\t" + txtpython.getText()
							
							+ "\n\t*******************************\n"
							
							+ "\n\tTotal Score:\t" + txtTotalscore.getText()
							+ "\n\tAverage:\t" + txtAverage.getText()
							+ "\n\tRanking:\t" + txtRank.getText()
							
							+ "\n");
					txtID.setText("");
					comboBoxcorse.setSelectedIndex(0);
					txtexam.setText("");
					txtfname.setText("");
					txtsname.setText("");
					txtjava.setText("");
					txtCsharp.setText("");
					txtCss.setText("");
					txtSqlite.setText("");
					txtVB.setText("");
					txtPhp.setText("");
					txtGit.setText("");
					txtpython.setText("");
					txtTotalscore.setText(""); 
					txtAverage.setText(""); 
					txtRank.setText("");
					if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you will like to print student's grade\n You can print it later by clicking/selecting row of the\nstudent and click on print button from print panel  ","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
					{
						
					MessageFormat header = new MessageFormat("Printing in progress");
					MessageFormat footer = new MessageFormat("Page (0, number, integer)");
					try{
						txtTranx.print();
						
					}catch(java.awt.print.PrinterException ev) {
						System.err.format("no printer found", ev.getMessage());
						
					}
					
					txtTranx.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "You couldn't print the result of the student!","Student Grading System", JOptionPane.OK_OPTION);
				
					
					
				}
					
				}
				
				
				
				}else {
					JOptionPane.showMessageDialog(null, "No student grades confirmed","Student Grading System", JOptionPane.OK_OPTION);
							
		}
			
			}
				
			}
		});
		
	
		btnResult.setBackground(new Color(32, 178, 170));
		btnResult.setToolTipText("Submit student result");
		btnResult.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btntran = new JButton("Transcript");
		btntran.setBounds(694, 348, 100, 33);
		btntran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty()|| comboBoxcorse.getSelectedItem().toString().isEmpty()|| txtfname.getText().isEmpty()|| txtexam.getText().isEmpty()||txtjava.getText().isEmpty()|| txtCsharp.getText().isEmpty()|| txtCss.getText().isEmpty()|| txtSqlite.getText().isEmpty()||txtVB.getText().isEmpty()||
						txtGit.getText().isEmpty()|| txtpython.getText().isEmpty() || txtTotalscore.getText().isEmpty()|| txtAverage.getText().isEmpty()|| txtRank.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Please all fields require input before generaing transcript");
					
				}
				else {
				txtTranx.setText("");
				txtTranx.append("\tStudent Grading System\n"
						+ "\n\t*******************************\n"
						+ "\tStudent ID:\t" + txtID.getText()
						+ "\n\tCourse code:\t" +  comboBoxcorse.getSelectedItem()
						+ "\n\tExams Code:\t"  + txtexam.getText()
						+ "\n\tFirst Name:\t" + txtfname.getText()
						+ "\n\tSurName:\t" + txtsname.getText()
						+ "\n\tJava:\t" + txtjava.getText()
						+ "\n\tC#:\t" + txtCsharp.getText()
						+ "\n\tCss:\t" + txtCss.getText()
						+ "\n\tSqlite:\t" + txtSqlite.getText()
						+ "\n\tVisualbasic:\t" + txtVB.getText()
						
						+ "\n\tPhp:\t" + txtPhp.getText()
						
						+ "\n\tGithub:\t" + txtGit.getText()
						
						+ "\n\tPython:\t" + txtpython.getText()
						
						+ "\n\t*******************************\n"
						
						+ "\n\tTotal Score:\t" + txtTotalscore.getText()
						+ "\n\tAverage:\t" + txtAverage.getText()
						+ "\n\tRanking:\t" + txtRank.getText()
						+ "\n");
				
				
				}
			}
		});
		btntran.setBackground(new Color(32, 178, 170));
		btntran.setToolTipText("Click to generat student transcript");
		btntran.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btnPrint = new JButton("Print");
		btnPrint.setBounds(866, 348, 87, 33);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTranx.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "No text in print field to print,click on the transcript button to generate it before printing");
					
					
				}else {
				
				MessageFormat header = new MessageFormat("Printing in progress");
				MessageFormat footer = new MessageFormat("Page (0, number, integer)");
				try{
					txtTranx.print();
					
				}catch(java.awt.print.PrinterException ev) {
					System.err.format("no printer found", ev.getMessage());
				}
				}
			}
		});
		btnPrint.setBackground(new Color(32, 178, 170));
		btnPrint.setToolTipText("Click here to print student transcript\r\n");
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(669, 618, 93, 33);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField temp = null;
				for(Component c:panel.getComponents()) {
					if(c.getClass().toString().contains("javax.swing.JTextField")) {
						temp=(JTextField)c;
						temp.setText(null);
					}
				}
				
				txtTranx.setText(null);
				comboBoxcorse.setSelectedIndex(0);
			}
		});
		btnReset.setBackground(new Color(32, 178, 170));
		btnReset.setToolTipText("Click to clear the text fields");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(860, 618, 93, 33);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mainframe = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you want to exit the application","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				
				System.exit(0);
				}
				
			}
		});
		btnExit.setBackground(new Color(32, 178, 170));
		btnExit.setToolTipText("Click to close the program");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(478, 618, 100, 33);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
					
				 try {
					 if(JOptionPane.showConfirmDialog(mainframe, "Confirm if you want to delete student grades","Student Grading System(SGS)", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
						{
					 
					
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						if(table.getSelectedRow()==-1) {
							
							if(table.getRowCount()==0) {
								JOptionPane.showMessageDialog(null, "no data to delete","Student Grading System(SGS)",JOptionPane.OK_OPTION);
								
							}else {
								JOptionPane.showMessageDialog(null, "Select a row to delete","Student Grading System(SGS)",JOptionPane.OK_OPTION);
							}
							
						}else {
							String delet = "DELETE FROM Grading WHERE StudentID='"+txtID.getText() + "' ";
							 PreparedStatement pre= conn.prepareStatement(delet);
							 pre.execute();
							 
							 pre.close();
							model.removeRow(table.getSelectedRow());
							JOptionPane.showMessageDialog(null,"Data deleted successfuly");
							
										txtID.setText("");
										comboBoxcorse.setSelectedIndex(0);
										txtexam.setText("");
										txtfname.setText("");
										txtsname.setText("");
										txtjava.setText("");
										txtCsharp.setText("");
										txtCss.setText("");
										txtSqlite.setText("");
										txtVB.setText("");
										txtPhp.setText("");
										txtGit.setText("");
										txtpython.setText("");
										txtTotalscore.setText(""); 
										txtAverage.setText(""); 
										txtRank.setText("");
										
							
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "no data deleted","Student Grading System(SGS)",JOptionPane.OK_OPTION);
					}	
						
						
					
					 
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}			  
				
										
					
				
			}
			
		});
		btnDelete.setToolTipText("Click to delete student result");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBackground(new Color(32, 178, 170));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 388, 1007, 219);
		scrollPane.setViewportBorder(new LineBorder(new Color(188, 143, 143), 4));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//populating data from table to the text fields
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				txtID.setText(model.getValueAt(SelectedRowIndex, 0).toString());
				comboBoxcorse.setSelectedItem(model.getValueAt(SelectedRowIndex, 1).toString());
				txtexam.setText(model.getValueAt(SelectedRowIndex, 2).toString());
				txtfname.setText(model.getValueAt(SelectedRowIndex,3).toString());
				txtsname.setText(model.getValueAt(SelectedRowIndex,4).toString());
				txtjava.setText(model.getValueAt(SelectedRowIndex, 5).toString());
				txtCsharp.setText(model.getValueAt(SelectedRowIndex, 6).toString());
				txtCss.setText(model.getValueAt(SelectedRowIndex, 7).toString());
				txtSqlite.setText(model.getValueAt(SelectedRowIndex, 8).toString());
				txtVB.setText(model.getValueAt(SelectedRowIndex, 9).toString());
				txtPhp.setText(model.getValueAt(SelectedRowIndex, 10).toString());
				txtGit.setText(model.getValueAt(SelectedRowIndex, 11).toString());
				txtpython.setText(model.getValueAt(SelectedRowIndex, 12).toString());
				txtTotalscore.setText(model.getValueAt(SelectedRowIndex, 13).toString());
				txtAverage.setText(model.getValueAt(SelectedRowIndex, 14).toString());
				txtRank.setText(model.getValueAt(SelectedRowIndex, 15).toString());
				
			}
			
			
		});
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
	
			
			
			
		
	}
	
		
	}
	

