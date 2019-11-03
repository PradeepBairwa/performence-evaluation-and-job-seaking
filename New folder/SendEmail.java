import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

class Email extends Authenticator
{
	 static int i;
	 static String s,j;
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication pa = new PasswordAuthentication
		("ENTER YOUR GMAIL", "PASSWORD");
		return pa;
	}
	void EmailByCode() throws Exception{

		
		
		
		
		// create object of properties to provide mail server
		Properties p = new Properties();
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port","587");
		p.put("mail.smtp.starttls.enable","true");
//		p.put("mail.smtp.ssl.trust","smtp.gmail.com");
		p.put("mail.smtp.auth","true");
//		p.put("mail.debug","true");

		// create object of subclass of authenticator
		Email baby = new Email();
		//baby.otp();
		// get a session
		Session session = Session.getInstance(p, baby);
		
		// create object for actual message
		MimeMessage message = new MimeMessage(session);
		
		// set subject of this message
		message.setSubject("password !!");
			
		InternetAddress address = new InternetAddress
				(""ENTER YOUR GMAIL");
		
		// set type of RCVR
		message.setRecipient(RecipientType.TO, address);

		
		message.setContent
		("your OTP is :"+j+"", "text/plain");
		
		Transport.send(message);
		
		System.out.println("\nMail sent");
		}
	
	void pass() {
		Random r=new Random();
		 i=r.nextInt(9999);
		  j=Integer.toString(i);
		System.out.print("your OTP is :"+j);
	}
}


class Email02 extends Authenticator
{
	 static int i;
	 static String s,j;

	 String pass;
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication pa = new PasswordAuthentication
		(""ENTER YOUR GMAIL", "PASSWORD");
		return pa;
	}
	
	
	void EmailByCode() throws Exception{
		LoginSystem pk =new LoginSystem();
System.out.println("Your Password is:"+pk.getpass);
		Properties p = new Properties();
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port","587");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth","true");
		Email baby = new Email();
		Session session = Session.getInstance(p, baby);
		MimeMessage message = new MimeMessage(session);
		message.setSubject("password !!");
		InternetAddress address = new InternetAddress
				(""ENTER YOUR GMAIL");
		message.setRecipient(RecipientType.TO, address);
		LoginSystem ls =new LoginSystem();
		message.setContent
		("your OTP is :"+ls.getpass+"", "text/plain");
		Transport.send(message);
		System.out.println("\nMail sent");
		}}


public class SendEmail extends Authenticator
{
	public static void main(String[] args) throws Exception 
	
	{
		//Email baby = new Email();
		//baby.pass();
		//baby.EmailByCode();
		Email02 e2=new Email02();
		e2.EmailByCode();
}}