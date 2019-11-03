import javax.swing.*;

import javax.swing.text.Document;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSetRow;
import com.mysql.jdbc.util.ResultSetUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import java.awt.Font;
 


public class StudentModule extends JFrame implements ActionListener
{  Font font = new Font("Courier", Font.BOLD,12);
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b99;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l11, l12,l13 ,l99;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10 ;
	String s3,name,s4,s7,s8;
	String tblName;
	JComboBox box;
	String[] tables;
	//private Statement stmt;
	private Test t1;
	static JFrame frame;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Studentmodule";
	   static final String USER = "root";
	   static final String PASS = "pradeep123.@";
	   static Connection conn = null;
	   static Statement stmt = null;
	JFrame login()
	{//Container f = getContentPane();
		JFrame f=new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		f.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setDefaultCloseOperation(3);
		b1=new JButton("Sign UP");   b1.setBounds(150, 100, 100, 40);  f.add(b1);
		b2=new JButton("Sign In");   b2.setBounds(150, 200, 100, 40);  f.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		frame = f;
		return f;
	}

	
	
	JFrame SignUp()
	{
		JFrame f=new JFrame("Login Form");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(3);
		l1=new JLabel("Name");              tf1=new JTextField();
		l2=new JLabel("Email");             tf2=new JTextField();
		l3=new JLabel("Mobile");            tf3=new JTextField();
		l4=new JLabel("Password");          tf4=new JTextField();
		l5=new JLabel("Qualification");     tf5=new JTextField();
		l6=new JLabel("Specifide");         tf6=new JTextField();
		l7=new JLabel("Passing Year");      tf7=new JTextField();
		b3=new JButton("SignUp");
		l1.setBounds(100, 30, 200, 40);           tf1.setBounds(200, 30, 200, 30);         
		l2.setBounds(100, 80, 200, 40);           tf2.setBounds(200, 80, 200, 30);  
		l3.setBounds(100, 130, 200, 40);          tf3.setBounds(200, 130, 200, 30);  
		l4.setBounds(100, 180, 200, 40);          tf4.setBounds(200, 180, 200, 30);  
		l5.setBounds(100, 230, 200, 40);          tf5.setBounds(200, 230, 200, 30);  
		l6.setBounds(100, 280, 200, 40);          tf6.setBounds(200, 280, 200, 30);  
		l7.setBounds(100, 330, 200, 40);          tf7.setBounds(200, 330, 200, 30);  
		b3.setBounds(180, 380, 150, 40);
		 f.add(l1);  f.add(tf1);  f.add(b3); b3.addActionListener(this);
		 f.add(l2);  f.add(tf2);
		 f.add(l3);  f.add(tf3);
		 f.add(l4);  f.add(tf4);
		 f.add(l5);  f.add(tf5);
		 f.add(l6);  f.add(tf6);
		 f.add(l7);  f.add(tf7);
		
			frame = f;
			return f;
	}
	void CreateTableForSignUp() 
	{String sql5="use studentmodule";
String sql1 = "create table IF NOT EXISTS studentmodule.studentdetails"+
		"(Name varchar(100),Email varchar(1000),Mobile varchar(700),Password varchar(50),Qualification varchar(100),Spacifide varchar(100),passingYear varchar(100),PRIMARY KEY ( Name ));";
		
			 Connection conn = null;
			   Statement stmt = null;
			   try{
				      //STEP 2: Register JDBC driver
				      try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn = DriverManager.getConnection(DB_URL, USER, PASS);
				      System.out.println("Connected database successfully...");
				      //STEP 4: Execute a query
				      stmt = conn.createStatement();
			stmt.executeUpdate(sql5);
			stmt.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}System.out.println("table created");
	
	}
	void InsertDetailsForSignUp() {
		
		String sql2="INSERT INTO studentdetails VALUES"
	+ "('"+tf1.getText()+"','"+tf2.getText()+"',"+tf3.getText()+",'"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"')";
		
		
		
			 Connection conn = null;
			   Statement stmt = null;
			   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn = DriverManager.getConnection(DB_URL, USER, PASS);
				      System.out.println("Connected database successfully...");
				      //STEP 4: Execute a query
				      stmt = conn.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}System.out.println("details are inserted");
	}
	
	void SignInstm()
	{ 
		
		String s2="select name from studentdetails where email='"+tf8.getText()+"'";
		 
			 Connection conn = null;
			   Statement stmt = null;
			   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn = DriverManager.getConnection(DB_URL, USER, PASS);
				      System.out.println("Connected database successfully...");
				      //STEP 4: Execute a query
				      stmt = conn.createStatement();
			 if(stmt != null)
			 {
			ResultSet s3=stmt.executeQuery(s2);
			while(s3.next()) {
				name=s3.getObject(1).toString();
			}
			 }
		 }catch(Exception e3) {System.out.println(e3); e3.printStackTrace();}
		
		
		if(tf8.getText().equals("")||(tf9.getText().equals("")))
	{
		JOptionPane.showMessageDialog(null, "please fill the form");
		return;
	}
		String emial=tf8.getText();
		String password=tf9.getText();
		String s1="SELECT password from studentdetails where email='"+tf8.getText()+"'";
		try {
			ResultSet rs=stmt.executeQuery(s1);
	String get_password="";
	while(rs.next()) {
		get_password=rs.getString(1);	
	}
	if(get_password.equals(tf9.getText())) 
	{
		JOptionPane.showMessageDialog(null, "login successfull");
		AfterLogin();	
		return;
		
	}
	else {
		JOptionPane.showMessageDialog(null, "user name or password is incorrect");
			return;
			}
		}catch(Exception e) {System.out.println(e);}
	}
	
	JFrame SignIn()
	{
		
		JFrame f=new JFrame("SignIn Form");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(3);
		l8=new JLabel("Email or Mobile");  tf8=new JTextField();
		l9=new JLabel("Password");         tf9=new JTextField();
		b4=new JButton("Sign In now"); b4.addActionListener(this);
		l8.setBounds(100, 100, 150, 40);   tf8.setBounds(200, 100, 150, 40);
		l9.setBounds(100, 180, 150, 40);   tf9.setBounds(200, 180, 150, 40);
		f.add(l8);f.add(tf8);   b4.setBounds(150, 300, 150, 40);
		f.add(l9);f.add(tf9);  f.add(b4);
		frame = f;
		return f;
	}
	JFrame AfterLogin()
	{
		JFrame f=new JFrame("After Login Form");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(3);
		l11 = new JLabel("welcome.."+name+"");
		l11.setFont(new Font("Serif", Font.PLAIN, 25));
		 l11.setBounds(130, 20, 200, 40);
		b5=new JButton("Give Exam");      b5.setBounds(150, 100, 150, 40);
		b6=new JButton("Give FeedBack");  b6.setBounds(150, 330, 150, 40);
		b7=new JButton("Get Result");     b7.setBounds(150, 170, 150, 40);
		b8=new JButton("Seek For Job");   b8.setBounds(150, 250, 150, 40);
		f.add(b5);b5.addActionListener(this);
		f.add(b6);b6.addActionListener(this);
		f.add(b7);
		f.add(b8);
		f.add(l11);
		frame = f;
		return f;
	}
	JLabel l22;
	JTextArea ta;
	JButton submit;

	JFrame FeedBack() {
			JFrame f=new JFrame();
			f.setSize(600, 600);
			f.setVisible(true);
			f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			StudentModule s=new StudentModule();
			l22 = new JLabel("welcome.."+name+"Your feedback is valueble for us");
			l22.setFont(new Font("Serif", Font.PLAIN, 25));
			ta=new JTextArea();
			ta.setLineWrap(true);	
			submit=new JButton("SUBMIT");
			submit.setBounds(200, 450, 100, 50);
			ta.setBounds(100, 80, 350, 350);
			 l22.setBounds(20, 20, 530, 40);
			 f.add(l22);
			 f.add(ta);
			 f.add(submit);
			 frame = f;
				return f;
			}
	
	JFrame GiveExam() {
		JFrame f=new JFrame("Give Exam");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(3);
		box = new JComboBox();   box.setBounds(210, 170, 150, 40);
		tf10=new JTextField();  tf10.setBounds(210, 230, 150, 30);
		l12=new JLabel(""+tblName+"");       l12.setBounds(180, 50, 350, 40);
		l13=new JLabel("Select Topic");l13.setBounds(120, 170, 150, 40);
		b9=new JButton("Proceed");     b9.setBounds(150, 330, 150, 40);
		f.add(l12);f.add(l13);f.add(box);f.add(tf10);
		f.add(b9);  b9.addActionListener(this);
		frame = f;
		return f;
	}
	void BackgroundImageJFrame() 
	{ 
		setTitle("Background Color for JFrame"); 
		setSize(400,400); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true); 


		setLayout(new BorderLayout()); 
		JLabel background=new JLabel(new ImageIcon 

		("C:/Users/LENOVO/Desktop/image.jpg"));
		//C:/Users/LENOVO/Desktop/image.jpg
		add(background); 
		background.setLayout(null); 
		 
		background.setBounds(100, 50, 800, 600); 
		setSize(600,600); 
		 
	}
	
	void StmtForGiveExam() {
		String s7="show tables";
		String s8="use majorproject";
		
		 
			 Connection conn = null;
			   Statement stmt = null;
			   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn = DriverManager.getConnection(DB_URL, USER, PASS);
				      System.out.println("Connected database successfully...");
				      //STEP 4: Execute a query
				      stmt = conn.createStatement();
				      
			 stmt.executeQuery(s8);
			ResultSet s9=stmt.executeQuery(s7);
			int count = 0;
			//while(s9.next()) {
				tables=s9.getMetaData().toString().split("");
				 count++;
				 ResultSet rs = null;
			      DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
			      rs = meta.getTables(null, null, null, new String[] {
			         "TABLE"
			      });
			     // int count = 0;
			      System.out.println("All table names are in test database:");
			      while (rs.next()) {
			          tblName = rs.getString("TABLE_NAME").toString();
			          
			         System.out.println(tblName);
			        // count++;
			      }
			      //System.out.println(count + " Rows in set ");
			//}
			
			//String[] array = ""+tables+"";
			      
		 }catch(Exception e3) {System.out.println(e3); e3.printStackTrace();}	
	}
	
	void StmtForGiveExam2() {
		
		String s10="select question,answer1,answer2,answer3,answer4 from "+tf10.getText()+" where q_no=2";
		String s99="show tables";
		Connection conn = null;
		   Statement stmt = null;
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      //STEP 4: Execute a query
			      stmt = conn.createStatement();
		
		
			stmt.executeQuery(s10);
			ResultSet s9=stmt.executeQuery(s10);
			System.out.println("ok");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		if(tf10.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "please fill the form");
			
			return;
		}else {
			//test class object
			Test t2=new Test();
			t2.test2();
		}
		
		
		
	}

	public static void main(String[] args) {
		StudentModule s=new StudentModule();
		
		s.login();
		//s.BackgroundImageJFrame();
	
		
		
		
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			       System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      //STEP 4: Execute a query
			      stmt = conn.createStatement();}
		   catch(Exception e) {System.out.println(e);e.printStackTrace();}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {			
			frame.dispose();
			SignUp();
		}
		if (e.getSource()==b2) {
			frame.dispose();
			SignIn();
		}
		if (e.getSource()==b3) {
			CreateTableForSignUp();
			InsertDetailsForSignUp();
	}
		if (e.getSource()==b4) {
			frame.dispose();
			//GiveExame();
			SignInstm();
			
			//AfterLogin();
			System.out.println("yes....");
		}
		if (e.getSource()==b5) {
			StmtForGiveExam();
			frame.dispose();
			GiveExam();	
		}
		if(e.getSource()==b6) {
			frame.dispose();
			FeedBack();
		}
		if (e.getSource()==b9) {
			
			StmtForGiveExam2();
			frame.dispose();
			Test t=new Test();
			t.proceed();
		
			
			
			
		}
		
		}
}

				
