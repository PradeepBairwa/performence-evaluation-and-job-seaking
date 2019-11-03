import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FeedBack {
JLabel l22;
JTextArea ta;
JButton submit;

	void FeedBack() {
		JFrame f=new JFrame();
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StudentModule s=new StudentModule();
		l22 = new JLabel("welcome.."+s.name+"  Your feedback is valueble for us");
		l22.setFont(new Font("Serif", Font.PLAIN, 25));
		ta=new JTextArea();
		ta.setLineWrap(true);	
		submit=new JButton("SUBMIT");
		submit.setBounds(200, 450, 100, 50);
		ta.setBounds(100, 80, 350, 350);
		 l22.setBounds(50, 20, 500, 40);
		 f.add(l22);
		 f.add(ta);
		 f.add(submit);
		
		}
	//not use in other classes
	public static void main(String[] args) {
		
        FeedBack fb=new FeedBack();
        fb.FeedBack();

	}

}
