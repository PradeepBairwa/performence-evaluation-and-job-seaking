import javax.swing.*;  
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminResponsbility extends JFrame implements ActionListener
{    JFrame f,f1,f2,f3;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,AddQ;
	JTextField tf1,tf2,tf3,tf4,topic_1,ans_1,ans_2,ans_3,ans_4,ans_5,Qst_1,Qst_no,Q_no;
	JLabel l1,l2,l3,l4,l5,ans1,ans2,ans3,ans4,ans5,topic1,Qst1,QstNo,Q_No1;
	String name;
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/majorproject";
	   static final String USER = "root";
	   static final String PASS = "pradeep123.@";
	   static JFrame frame;
	   
	JFrame AdminWindow()
	{
		JFrame f=new JFrame();
		f.setSize(500,500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(3);
		f.setTitle("Admin Responsibilty" );
		
		b1=new JButton("Add Topics");           b1.addActionListener((ActionListener) this);
		b2=new JButton("Delete Topics");        b2.addActionListener((ActionListener) this);
		b3=new JButton("Add Question in Topic"); b3.addActionListener((ActionListener) this);
		b4=new JButton("delete Question from Topics");b4.addActionListener((ActionListener) this);
		b5=new JButton("View students");
		b6=new JButton("Provide Assistance for Poor students");
		b7=new JButton("Approve and Disapprove Company");
		b8=new JButton("Approve Feedback of Studens");
		
		b1.setBounds(150, 30, 200, 40);           f.add(b1);
		b2.setBounds(150, 80, 200, 40);           f.add(b2);
		b3.setBounds(150, 130, 200, 40);          f.add(b3);
		b4.setBounds(150, 180, 200, 40);          f.add(b4);
		b5.setBounds(150, 230, 200, 40);          f.add(b5);
		b6.setBounds(150, 280, 200, 40);          f.add(b6);
		b7.setBounds(150, 330, 200, 40);          f.add(b7);
		b8.setBounds(150, 380, 200, 40);          f.add(b8);
		frame = f;
		return f;
	}
	JFrame redirectHome()
	{
		JFrame f3=new JFrame("redirectHome");
		f3.setBounds(100, 100, 400, 200);
		f3.setVisible(true);
		f3.setLayout(null);
		f3.setDefaultCloseOperation(3);
		JLabel l1=new JLabel("Topic is Added and we are redirect to the HomePage");
		 b10=new JButton("ok");     b10.addActionListener(this);
		l1.setBounds(50, 50, 320, 40);       f3.add(l1);
		b10.setBounds(150, 100, 100, 40);    f3.add(b10);
		frame = f;
		return f;
	}
	JFrame redirectHome1()
	{
		JFrame f3=new JFrame("redirectHome1");
		f3.setBounds(100, 100, 400, 200);
		f3.setVisible(true);
		f3.setLayout(null);
		f3.setDefaultCloseOperation(3);
		JLabel l1=new JLabel("Topic is deleted and we are redirect to the HomePage");
		 b13=new JButton("ok");    b13.addActionListener(this);
		l1.setBounds(50, 50, 320, 40);      f3.add(l1);
		b13.setBounds(150, 100, 100, 40);   f3.add(b13);
		frame = f;
		return f;
	}
	JFrame redirectHome2()
	{
		JFrame f3=new JFrame("redirectHome2");
		f3.setBounds(00, 100, 400, 200);
		f3.setVisible(true);
		f3.setLayout(null);
		f3.setDefaultCloseOperation(3);
		JLabel l5=new JLabel("Question is deleted and we are redirect to the HomePage");
		 b15=new JButton("ok");    b15.addActionListener(this);
		l5.setBounds(30, 50, 330, 40);      f3.add(l5);
		b15.setBounds(150, 100, 100, 40);   f3.add(b15);
		frame = f;
		return f;
	}
	JFrame AddTopics()
	{
		JFrame f1=new JFrame();
		f1.setSize(400,400);
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(3);
		f1.setTitle("Add Topics");
		tf1=new JTextField("hello");
		l1=new JLabel("ADD TOPICS");
		b9=new JButton("ADD");               b9.addActionListener(this);
		tf1.setBounds(180, 100, 150, 40);    f1.add(tf1);
		b9.setBounds(100, 200, 150, 40);     f1.add(b9);  
		l1.setBounds(80, 100, 150, 40);      f1.add(l1);
		frame = f;
		return f;
	
	}
	JFrame DeleteTopic()
	{
		JFrame f1=new JFrame();
		f1.setSize(400,400);
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(3);
		f1.setTitle("Delete Topics");
		tf2=new JTextField("hello");
		l2=new JLabel("DELETE TOPICS");
		b11=new JButton("DELETE");              b11.addActionListener(this);
		tf2.setBounds(180, 100, 150, 40);       f1.add(tf2);
		b11.setBounds(100, 200, 150, 40);       f1.add(b11);  
		l2.setBounds(80, 100, 150, 40);      	f1.add(l2);
		frame = f;
		return f;
	}
	JFrame DeleteQuestionFromTopic()
	{
		JFrame f1=new JFrame();
		f1.setSize(400,400);
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(3);
		f1.setTitle("Delete Topics");
		tf3=new JTextField();
		tf4=new JTextField();
		l3=new JLabel("Entere Topic");
		l4=new JLabel("Question");
		b14=new JButton("DELETE");              b14.addActionListener(this);
		tf3.setBounds(200, 100, 130, 30);       f1.add(tf3);
		tf4.setBounds(200, 140, 130, 30);        f1.add(tf4);
		b14.setBounds(100, 200, 150, 40);       f1.add(b14);  
		l3.setBounds(50, 100, 170, 40);      	f1.add(l3);
		l4.setBounds(50, 140, 170, 40);          f1.add(l4);
		frame = f;
		return f;
	}
	void DropTopic()
	{
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
			      String s1="drop table "+tf2.getText()+"";
			      stmt.executeUpdate(s1);
			      System.out.println("Deleted table in given database...");}
		   catch(Exception e)
		   {
			   System.out.println(e);
			   e.printStackTrace();
			   
		   }
	}
	void DropQuestionFromTopic()
	{
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
			      String s1 = "delete from "+tf3.getText()+" where question = '"+tf4.getText()+"'";
			      stmt.executeUpdate(s1);
			      System.out.println("Deleted table in given database...");}
		   catch(Exception e)
		   {
			   System.out.println(e);
			   e.printStackTrace();
		   }
	}
	void CreateTable()
	{
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
			      System.out.println("Creating table in given database...");
			      stmt = conn.createStatement();
			      String sqlc = "create table IF NOT EXISTS majorproject."+ tf1.getText()+
 "(q_no int NOT NULL AUTO_INCREMENT,question varchar(767),answer1 varchar(1000),answer2 varchar(1000),"
 + "answer3 varchar(1000),answer4 varchar(1000),correctanswer varchar(1000),PRIMARY KEY ( q_no ));";
			    		       
			     stmt.executeUpdate(sqlc);
			      System.out.println("Created table in given database...");
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			}
	JFrame AddQuestion()
	{
		JFrame f2=new JFrame();
		f2.setSize(500,500);
		f2.setVisible(true);
		f2.setLayout(null);
		f2.setDefaultCloseOperation(3);
		f2.setTitle("Add Questions");
		QstNo=new JLabel("Pev Q.no"+name+"");        Qst_no=new JTextField();
		topic1=new JLabel("Topic");          topic_1=new JTextField();  // JComboBox combo1 = new JComboBox(s1);
		Q_No1=new JLabel("Question no");          Q_no=new JTextField();
		Qst1=new JLabel("Qusetion :");       Qst_1=new JTextField();
		ans1=new JLabel("Answer:1");         ans_1=new JTextField();
		ans2=new JLabel("Answer:2");         ans_2=new JTextField();
		ans3=new JLabel("Answer:3");         ans_3=new JTextField();
		ans4=new JLabel("Answer:4");         ans_4=new JTextField();
		ans5=new JLabel("Correct Answer:");  ans_5=new JTextField();
		AddQ=new JButton("Add Question");        AddQ.addActionListener(this);
		f2.add(QstNo);       // f2.add(Qst_no);
		f2.add(topic1);       f2.add(topic_1);
		f2.add(Qst1);         f2.add(Qst_1);
		//f2.add(Q_No1);         f2.add(Q_no);
		f2.add(ans1);         f2.add(ans_1);
		f2.add(ans2);         f2.add(ans_2);
		f2.add(ans3);         f2.add(ans_3);
		f2.add(ans4);         f2.add(ans_4);
		f2.add(ans5);         f2.add(ans_5);
		f2.add(AddQ);
		QstNo.setBounds(330, 10, 80, 30);    Qst_no.setBounds(400, 10, 50, 30);
		topic1.setBounds(100, 40, 150, 30);    topic_1.setBounds(200, 40, 150, 30);
		Q_No1.setBounds(100, 90, 150, 30);    Q_no.setBounds(200, 90, 150, 30);
		Qst1.setBounds(100, 130, 150, 30);    Qst_1.setBounds(200, 130, 150, 30);
		ans1.setBounds(100, 170, 150, 30);    ans_1.setBounds(200, 170, 150, 30);
		ans2.setBounds(100, 210, 150, 30);    ans_2.setBounds(200, 210, 150, 30);
		ans3.setBounds(100, 250, 150, 30);    ans_3.setBounds(200, 250, 150, 30);
		ans4.setBounds(100, 290, 150, 30);    ans_4.setBounds(200, 290, 150, 30);
	    ans5.setBounds(100, 330, 150, 30);    ans_5.setBounds(200, 330, 150, 30);
	    AddQ.setBounds(150, 380, 150, 30);
	    frame = f;
		return f;
	}
	void AddQstInDatabase()
	{ 	 Connection conn = null;
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
		      String Q="select count(*) from c";
		      
		      try{
					ResultSet s3=stmt.executeQuery(Q);
					while(s3.next()) {
						name=s3.getObject(1).toString();
					}
				 }catch(Exception e3) {System.out.println(e3);e3.printStackTrace();}
		      
		      
		  String sql = "INSERT INTO "+topic_1.getText()+""
		  		+ "(question,answer1,answer2,answer3,answer4,correctanswer)"
+ " VALUES ('"+Qst_1.getText()+"','"+ans_1.getText()+"','"+ans_2.getText()+"','"+ans_3.getText()+"','"+ans_4.getText()+"','"+ans_5.getText()+"')";                                       
                  System.out.println("hii");
		  stmt.executeUpdate(sql);}
		 
		  catch(Exception e) {
			  System.out.println(e);
			  e.printStackTrace(); 
		  }  
	}
	public static void main(String[] args) 
	{
		AdminResponsbility ar=new AdminResponsbility();
		ar.AdminWindow();

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{	
		System.out.println("button is working");
		frame.dispose();
		AddTopics();
		}
		if(e.getSource()==b9) {
			
			System.out.println(tf1.getText());
			CreateTable();
			redirectHome();
			//frame.dispose();
		}
		if(e.getSource()==b3) {
			System.out.println("hmmmmm");
			frame.dispose();
			AddQuestion();
		}
		if(e.getSource()==b2) {
			frame.dispose();
			DeleteTopic();
		}
		if(e.getSource()==AddQ) {
			AddQstInDatabase();
			AddQstInDatabase();
		}
		if(e.getSource()==b10) {
			//frame.dispose();
			AdminWindow();	
		}
		if(e.getSource()==b11) {
			//frame.dispose();
			DropTopic();
			redirectHome1();	
		}
		if(e.getSource()==b13) {
			//frame.dispose();
			AdminWindow();
		}
		if(e.getSource()==b4) {
			//frame.dispose();
			DeleteQuestionFromTopic();
		}
		if(e.getSource()==b14) {
			DropQuestionFromTopic();
			//frame.dispose();
			redirectHome2();
		}
		if(e.getSource()==b15) {
			//frame.dispose();
			 AdminWindow();
		}
	}

}
