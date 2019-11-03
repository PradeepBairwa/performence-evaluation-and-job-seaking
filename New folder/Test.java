import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/majorproject";
	   static final String USER = "root";
	   static final String PASS = "pradeep123.@";
	   static Connection conn = null;
	   static Statement stmt = null;
	
	JLabel l,l1,l2,l3,l4;  
JRadioButton jb[]=new JRadioButton[5];  
JButton b1,b2,b3;  
ButtonGroup bg; 
String name,name1,name2,name3,name4,s2,s3;
int count=0,current=0,x=1,y=1,now=0,i=0,j=0;  
int m[]=new int[10];
String[] questions=new String[10];
JTextField tf10;

JLabel jl1,jl2,jl3,jl4,jlQ;
JRadioButton r_ans1,r_ans2,r_ans3,r_ans4;
JButton b11,b22;

JComboBox box;
void proceed()
{
	JFrame f=new JFrame();
	f.setSize(400, 400);
	f.setVisible(true);
	f.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	box = new JComboBox();   box.setBounds(210, 50, 150, 40); f.add(box);
	tf10=new JTextField();  tf10.setBounds(150, 100, 100, 40);  f.add(tf10);
	//f.setDefaultCloseOperation(3);
	//b1=new JButton("Sign UP");   b1.setBounds(150, 100, 100, 40);  f.add(b1);
	b3=new JButton("proceed");   b3.setBounds(150, 200, 100, 40);  f.add(b3);
	//b1.addActionListener(this);
	b3.addActionListener(this);
	//frame = f;
}

	
	 void test2() {
	        JFrame frame = new JFrame("test");
	        frame.setSize(600, 500);
	        frame.setLayout(null);
	        frame.setVisible(true);
	        jlQ=new JLabel(""+name+""); jlQ.setBounds(50, 50, 600, 40);
	        jlQ.setFont(new Font("Serif", Font.PLAIN, 20));
	        b11=new JButton("Next");  
	        b22=new JButton("Bookmark");  
	        b11.addActionListener(this);  
	        b22.addActionListener(this);
	         r_ans1 = new JRadioButton("A)");  jl1=new JLabel(""+name1+"");
	         r_ans2 = new JRadioButton("B)");  jl2=new JLabel(""+name2+"");
	         r_ans3 = new JRadioButton("C)");  jl3=new JLabel(""+name3+"");
	         r_ans4 = new JRadioButton("D)");  jl4=new JLabel(""+name4+"");
	        r_ans1.setBounds(50, 150, 50, 40);jl1.setBounds(100, 150, 300, 40);
	        r_ans2.setBounds(50, 200, 50, 40);jl2.setBounds(100, 200, 300, 40);
	        r_ans3.setBounds(50, 250, 50, 40);jl3.setBounds(100, 250, 300, 40);
	        r_ans4.setBounds(50, 300, 50, 40);jl4.setBounds(100, 300, 300, 40);
	        b11.setBounds(100,370,100,30);  
	        b22.setBounds(270,370,100,30); 
	        ButtonGroup btn_grp = new ButtonGroup();
	        btn_grp.add(r_ans1);  frame.add(jl1);
	        btn_grp.add(r_ans2);  frame.add(jl2);
	        btn_grp.add(r_ans3);  frame.add(jl3);
	        btn_grp.add(r_ans4);  frame.add(jl4);
	        frame.add(r_ans1);
	        frame.add(r_ans2);
	        frame.add(r_ans3);
	        frame.add(r_ans4);
	        frame.add(jlQ);
	        frame.add(b11);
	        frame.add(b22);
	    }
void statement() {
	StudentModule s=new StudentModule();
	
	 String s1 = "select question from "+tf10.getText()+" where q_no = '1'";
	 String s2 = "select answer1  from "+tf10.getText()+" where q_no = '1'";
	 String s3 = "select answer2  from "+tf10.getText()+" where q_no = '1'";
	 String s4 = "select answer3  from "+tf10.getText()+" where q_no = '1'";
	 String s5 = "select answer4  from "+tf10.getText()+" where q_no = '1'";
	String s6="select question from c ";
		String s7="show tables from majorproject";
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
				      ResultSet r0=stmt.executeQuery(s7);
				      while(r0.next()) {
				    	//  String name =r0.getString(answer1);
				      }
				      
				      
				      
			
			ResultSet r1=stmt.executeQuery(s1);
			while(r1.next()) {
				name=r1.getObject(1).toString();}
		
		 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
		 
		 try{
				ResultSet r2=stmt.executeQuery(s2);
				while(r2.next()) {
					name1=r2.getObject(1).toString();}
			
			 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
		 try{
				ResultSet r3=stmt.executeQuery(s3);
				while(r3.next()) {
					name2=r3.getObject(1).toString();}
			
			 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
		 try{
				ResultSet r4=stmt.executeQuery(s4);
				while(r4.next()) {
					name3=r4.getObject(1).toString();}
			
			 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
		 try{
				ResultSet r5=stmt.executeQuery(s5);
				while(r5.next()) {
					name4=r5.getObject(1).toString();}
			
			 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
	
		 System.out.println("h kuch  "+name);
		 
		//---------------------------------------------------------------
		
			// -----------------------------------------------------------------
		
		}
		 
		 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Test t=new Test();
t.proceed();



try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();}
catch(Exception e) {System.out.println(e);}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b3)
		{
			statement();
			test2();
			System.out.println("hii");
		}
		
	}

}
