import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginSystem extends JFrame implements ActionListener
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/Studentmodule";
static final String USER = "root";
static final String PASS = "pradeep123.@";
static Connection conn =null;
static Statement stmt = null;
	
	JButton b1,b2,b3,b4,b5,b6;
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4;
	 static String otp,getpass;
	static JFrame frame;
JFrame LoginWindow()
{
	JFrame f=new JFrame("Login Window");
	f.setSize(400, 400);
	f.setVisible(true);
	f.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	b1=new JButton("Admin");      b1.setBounds(100, 100, 150, 40);
	b2=new JButton("Student");     b2.setBounds(100, 200, 150, 40);
	f.add(b1);  b1.addActionListener(this);
	f.add(b2);  b2.addActionListener(this);
	frame = f;
	return f;
}

JFrame AdminLogin()
{
	JFrame f=new JFrame("Login Window");
	f.setSize(400, 400);
	f.setVisible(true);
	f.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	l1=new JLabel("User Name");   tf1= new JTextField();
	l2=new JLabel("Password");    tf2=new JTextField();
	b3=new JButton("Sign In");        b3.setBounds(100, 200, 150, 40);
	b4=new  JButton("Forget Password");b4.setBounds(30, 300, 150, 20);
	
	l1.setBounds(50, 50, 150, 40);  tf1.setBounds(150, 50, 150, 40); 
	 l2.setBounds(50, 100, 150, 40); tf2.setBounds(150, 100, 150, 40); 
	 
	f.add(l1);   f.add(tf1);
	f.add(l2);   f.add(tf2);
	f.add(b3);b3.addActionListener(this);
	f.add(b4);b4.addActionListener(this);
	frame = f;
	return f;
}
JFrame forgetPass() {
	JFrame f=new JFrame("forget pass");
	f.setSize(400, 400);
	f.setVisible(true);
	f.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	l5=new JLabel("Enter Email");
	tf4=new JTextField();
	l5.setBounds(50, 100, 250, 40); f.add(l5);
	tf4.setBounds(150, 100, 150, 40); f.add(tf4);
	 b6=new JButton("procced"); b6.addActionListener(this);
	b6.setBounds(100, 250, 150, 40); f.add(b6);
	
	frame = f;
	return f;
}
void stmtForforgetpass() {
	//String email=tf4.getText();
	String s1="select password from admindetails where email='"+tf4.getText()+"'";
	try {
		ResultSet rs=stmt.executeQuery(s1);
		 getpass="";
		while(rs.next()) {
		getpass=rs.getString(1);
		System.out.println(getpass);}
	
	}catch(Exception e) {
		System.out.println(e);e.printStackTrace();}
	}

void SignInStatment() {
	if(tf1.getText().equals("")||(tf2.getText().equals("")))
	{
		JOptionPane.showMessageDialog(null, "please fill the form");
		return;
	}
		String emial=tf1.getText();
		String password=tf2.getText();
		String s1="SELECT password from admindetails where email='"+tf1.getText()+"'";
		try {
			ResultSet rs=stmt.executeQuery(s1);
	String get_password="";
	while(rs.next()) {
		get_password=rs.getString(1);	
	}
	if(get_password.equals(tf2.getText())) 
	{
		System.out.println( "login successfull");
		//calling otp method
		OTP();
		//create object of sendemail class
		Email baby = new Email();
		baby.pass();
		baby.EmailByCode();
		new SendEmail();
		return;
		
	}
	else {
		System.out.println( "user name or password is incorrect");
			
			}
		}catch(Exception e) {System.out.println(e);
		e.printStackTrace();}
	}
JFrame OTP() {
	JFrame f=new JFrame("OTP window");
	f.setSize(400, 400);
	f.setVisible(true);
	f.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	l4=new JLabel("OTP will send in your Email");
	l3=new JLabel("Enter OTP");
	tf3=new JTextField();
	b5=new JButton("Verify"); b5.addActionListener(this);
	l4.setBounds(50, 50, 250, 40); f.add(l4);
	l3.setBounds(50, 150, 150, 40); f.add(l3);
	tf3.setBounds(150, 150, 150, 40); f.add(tf3);
	b5.setBounds(100, 250, 150, 40); f.add(b5);
	frame = f;
	return f;
}

void StatmentForVerify() {
	Email baby = new Email();
	//baby.pass();
	
	otp=tf3.getText();
	if(tf3.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "please fill the form");
		return;
	}
	
	if(otp.equals(baby.j) ) {
		JOptionPane.showMessageDialog(null, "login successfull hehehe");
		AdminResponsbility ar=new AdminResponsbility();
		ar.AdminWindow();
		return;
	}
	else {
		JOptionPane.showMessageDialog(null, "incorrect otp");
		
	return;
	}
}

	public static void main(String[] args)
	{
		LoginSystem ls =new LoginSystem();
		ls.LoginWindow();
		//ls.OTP();
		
		  try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		       System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();}
	   catch(Exception e) {System.out.println(e); e.printStackTrace();}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b2) {
		
		frame.dispose();
	StudentModule s=new StudentModule();
		s.login();
		
	}
	if (e.getSource()==b1) {
		frame.dispose();
		AdminLogin();
	}
	if (e.getSource()==b3) {
		SignInStatment();
	}
		if(e.getSource()==b5) {
			//frame.dispose();
			StatmentForVerify();
		}
		if (e.getSource()==b4) {
			forgetPass(); 
		}
		if(e.getSource()==b6) {
			stmtForforgetpass();
			Email02 e2=new Email02();
			try {
				e2.EmailByCode();
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
		}
	}

}
